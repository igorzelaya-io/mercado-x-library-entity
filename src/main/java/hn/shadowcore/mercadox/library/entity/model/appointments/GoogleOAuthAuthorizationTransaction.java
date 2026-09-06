package hn.shadowcore.mercadox.library.entity.model.appointments;

import hn.shadowcore.mercadox.library.entity.model.enums.GoogleCalendarAuthorizationPurpose;

import java.time.Instant;
import java.util.UUID;

public record GoogleOAuthAuthorizationTransaction(
        UUID orgId,
        String administratorEmail,
        String returnPath,
        GoogleCalendarAuthorizationPurpose purpose,
        Instant createdAt,
        Instant expiresAt
) {
}
