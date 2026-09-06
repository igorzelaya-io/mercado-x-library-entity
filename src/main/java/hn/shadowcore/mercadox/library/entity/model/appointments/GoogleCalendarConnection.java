package hn.shadowcore.mercadox.library.entity.model.appointments;

import hn.shadowcore.mercadox.library.entity.model.TenantBaseEntity;
import hn.shadowcore.mercadox.library.entity.model.enums.GoogleCalendarConnectionStatus;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "google_calendar_connection", schema = "appointments")
@AttributeOverride(name = "orgId", column = @Column(name = "org_id", nullable = false))
public class GoogleCalendarConnection extends TenantBaseEntity {

    @Id
    private UUID id;

    @Column(name = "google_subject", nullable = false, length = 255)
    private String googleSubject;

    @Column(name = "google_account_email", nullable = false, length = 320)
    private String googleAccountEmail;

    @Column(name = "refresh_token_ciphertext", columnDefinition = "TEXT")
    private String refreshTokenCiphertext;

    @Column(name = "credential_key_version", length = 255)
    private String credentialKeyVersion;

    @Column(name = "granted_scopes", nullable = false, columnDefinition = "TEXT")
    private String grantedScopes;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 24)
    private GoogleCalendarConnectionStatus status;

    @Column(name = "created_by_user_email", nullable = false, length = 320)
    private String createdByUserEmail;

    @Column(name = "last_successful_refresh_at")
    private Instant lastSuccessfulRefreshAt;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private Instant updatedAt;

    protected GoogleCalendarConnection() {
        // Required by JPA.
    }
}
