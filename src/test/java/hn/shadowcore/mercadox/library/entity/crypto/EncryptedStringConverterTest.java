package hn.shadowcore.mercadox.library.entity.crypto;

import org.junit.jupiter.api.Test;

import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EncryptedStringConverterTest {

    private final EncryptedStringConverter converter =
            new EncryptedStringConverter(new IdentityMasterKeyService());

    @Test
    void roundTrip_encryptThenDecrypt_returnsOriginalPlaintext() {
        String plaintext = "EAAG...meta-access-token";

        String stored = converter.convertToDatabaseColumn(plaintext);
        String recovered = converter.convertToEntityAttribute(stored);

        assertThat(recovered).isEqualTo(plaintext);
    }

    @Test
    void convertToDatabaseColumn_producesCiphertextThatDoesNotContainThePlaintext() {
        String plaintext = "EAAG...meta-access-token";

        String stored = converter.convertToDatabaseColumn(plaintext);

        assertThat(stored).isNotEqualTo(plaintext);
        assertThat(stored).doesNotContain(plaintext);
    }

    @Test
    void convertToDatabaseColumn_isNonDeterministic_dueToRandomNoncePerCall() {
        String plaintext = "same-token-every-time";

        String first = converter.convertToDatabaseColumn(plaintext);
        String second = converter.convertToDatabaseColumn(plaintext);

        assertThat(first).isNotEqualTo(second);
        assertThat(converter.convertToEntityAttribute(first)).isEqualTo(plaintext);
        assertThat(converter.convertToEntityAttribute(second)).isEqualTo(plaintext);
    }

    @Test
    void convertToDatabaseColumn_null_returnsNull() {
        assertThat(converter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    void convertToEntityAttribute_null_returnsNull() {
        assertThat(converter.convertToEntityAttribute(null)).isNull();
    }

    @Test
    void convertToEntityAttribute_tamperedCiphertext_failsWithGcmAuthError() {
        String stored = converter.convertToDatabaseColumn("secret-token");
        byte[] packed = Base64.getDecoder().decode(stored);
        packed[packed.length - 1] ^= 0x01; // flip the last ciphertext byte
        String tampered = Base64.getEncoder().encodeToString(packed);

        assertThatThrownBy(() -> converter.convertToEntityAttribute(tampered))
                .isInstanceOf(IllegalStateException.class);
    }

    /** Isolates the converter's own packing/crypto logic from MasterKeyService's correctness. */
    private static class IdentityMasterKeyService implements MasterKeyService {
        @Override
        public byte[] wrap(byte[] dataKey) {
            return dataKey;
        }

        @Override
        public byte[] unwrap(byte[] wrappedDataKey) {
            return wrappedDataKey;
        }
    }
}
