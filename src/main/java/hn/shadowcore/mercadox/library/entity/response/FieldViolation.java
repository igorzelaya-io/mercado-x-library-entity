package hn.shadowcore.mercadox.library.entity.response;

public record FieldViolation(
        String field,
        String message
) {
}
