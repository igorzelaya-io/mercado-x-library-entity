package hn.shadowcore.mercadox.library.entity.request;

public interface IdempotentRequest {
    String getIdempotencyKey();
}
