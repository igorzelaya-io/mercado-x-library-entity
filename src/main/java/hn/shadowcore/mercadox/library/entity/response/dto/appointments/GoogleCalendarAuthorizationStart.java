package hn.shadowcore.mercadox.library.entity.response.dto.appointments;

import hn.shadowcore.mercadox.library.entity.model.enums.GoogleCalendarAuthorizationPurpose;

import java.net.URI;
import java.time.Instant;

public record GoogleCalendarAuthorizationStart(
        URI authorizationUrl,
        Instant expiresAt,
        GoogleCalendarAuthorizationPurpose purpose
) {
}
