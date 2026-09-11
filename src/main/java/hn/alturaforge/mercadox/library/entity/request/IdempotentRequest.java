package hn.alturaforge.mercadox.library.entity.request;

public interface IdempotentRequest {
    String getIdempotencyKey();
}
