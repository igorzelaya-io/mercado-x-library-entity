package hn.shadowcore.mercadoxlibrary.entity.response.dto;

import java.sql.Timestamp;

public record VerificationToken(
    String id,

    Timestamp expiresAt,

    String userId

) { }
