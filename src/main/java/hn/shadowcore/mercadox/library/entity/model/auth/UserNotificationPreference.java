package hn.shadowcore.mercadox.library.entity.model.auth;

import hn.shadowcore.mercadox.library.entity.model.enums.TemplateChannel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "user_notification_preference", schema = "auth",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "channel"}))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserNotificationPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "channel", nullable = false)
    @Enumerated(EnumType.STRING)
    private TemplateChannel channel;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

}
