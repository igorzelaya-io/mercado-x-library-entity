package hn.shadowcore.mercadox.library.entity.response.dto;

import java.sql.Timestamp;

public record VerificationTokenDto(
    String id,

    Timestamp expiresAt,

    String userId

) { }
