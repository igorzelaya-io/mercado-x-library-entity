package hn.shadowcore.mercadox.library.entity.crypto;

/**
 * Wraps/unwraps a per-value data-encryption-key (DEK) under a master key.
 * Implementations are swappable (env-var-held key today, KMS-backed later) — callers
 * (namely {@link EncryptedStringConverter}) depend only on this contract.
 */
public interface MasterKeyService {

    byte[] wrap(byte[] dataKey) throws MasterKeyOperationException;

    byte[] unwrap(byte[] wrappedDataKey) throws MasterKeyOperationException;
}
