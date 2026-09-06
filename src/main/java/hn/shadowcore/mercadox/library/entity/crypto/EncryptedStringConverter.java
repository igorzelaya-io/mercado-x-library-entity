package hn.shadowcore.mercadox.library.entity.crypto;

import jakarta.persistence.AttributeConverter;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Envelope-encrypts a String column: AES-256-GCM under a random per-value data key (DEK),
 * with the DEK itself wrapped by {@link MasterKeyService}. A fresh DEK (and nonce) per value
 * — rather than one static key reused across rows — is what makes GCM's "never reuse a nonce
 * under the same key" requirement trivially safe even at high write volume.
 *
 * Stored layout (base64 of the packed bytes):
 * [1B version][4B wrappedDek length][wrappedDek][12B GCM nonce][ciphertext + 16B GCM tag]
 *
 * Not {@code @Converter(autoApply = true)} — must be opted into explicitly per field via
 * {@code @Convert(converter = EncryptedStringConverter.class)}. {@code @Component} (with no
 * no-arg constructor) forces Hibernate to resolve this through Spring's bean container rather
 * than instantiating it directly, so {@link MasterKeyService} can be constructor-injected.
 */
@Component
public class EncryptedStringConverter implements AttributeConverter<String, String> {

    private static final byte FORMAT_VERSION = 1;
    private static final int GCM_NONCE_LENGTH_BYTES = 12;
    private static final int GCM_TAG_LENGTH_BITS = 128;
    private static final int AES_KEY_SIZE_BITS = 256;

    private final MasterKeyService masterKeyService;
    private final SecureRandom secureRandom = new SecureRandom();

    public EncryptedStringConverter(MasterKeyService masterKeyService) {
        this.masterKeyService = masterKeyService;
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        if (attribute == null) {
            return null;
        }
        try {
            SecretKey dek = generateDek();
            byte[] nonce = new byte[GCM_NONCE_LENGTH_BYTES];
            secureRandom.nextBytes(nonce);

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, dek, new GCMParameterSpec(GCM_TAG_LENGTH_BITS, nonce));
            byte[] ciphertextAndTag = cipher.doFinal(attribute.getBytes(StandardCharsets.UTF_8));

            byte[] wrappedDek = masterKeyService.wrap(dek.getEncoded());

            ByteBuffer buffer = ByteBuffer.allocate(
                    1 + 4 + wrappedDek.length + GCM_NONCE_LENGTH_BYTES + ciphertextAndTag.length);
            buffer.put(FORMAT_VERSION);
            buffer.putInt(wrappedDek.length);
            buffer.put(wrappedDek);
            buffer.put(nonce);
            buffer.put(ciphertextAndTag);

            return Base64.getEncoder().encodeToString(buffer.array());
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("Failed to encrypt column value", e);
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            ByteBuffer buffer = ByteBuffer.wrap(Base64.getDecoder().decode(dbData));

            byte version = buffer.get();
            if (version != FORMAT_VERSION) {
                throw new IllegalStateException("Unsupported encrypted column format version: " + version);
            }
            int wrappedDekLength = buffer.getInt();
            byte[] wrappedDek = new byte[wrappedDekLength];
            buffer.get(wrappedDek);
            byte[] nonce = new byte[GCM_NONCE_LENGTH_BYTES];
            buffer.get(nonce);
            byte[] ciphertextAndTag = new byte[buffer.remaining()];
            buffer.get(ciphertextAndTag);

            byte[] dekBytes = masterKeyService.unwrap(wrappedDek);
            SecretKey dek = new SecretKeySpec(dekBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, dek, new GCMParameterSpec(GCM_TAG_LENGTH_BITS, nonce));
            byte[] plaintext = cipher.doFinal(ciphertextAndTag);

            return new String(plaintext, StandardCharsets.UTF_8);
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("Failed to decrypt column value", e);
        }
    }

    private SecretKey generateDek() throws GeneralSecurityException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(AES_KEY_SIZE_BITS, secureRandom);
        return keyGenerator.generateKey();
    }
}
