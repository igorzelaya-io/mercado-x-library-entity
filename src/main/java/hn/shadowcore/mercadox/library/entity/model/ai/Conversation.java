package hn.shadowcore.mercadox.library.entity.model.ai;

import hn.shadowcore.mercadox.library.entity.model.TenantBaseEntity;
import hn.shadowcore.mercadox.library.entity.model.enums.ConversationChannel;
import hn.shadowcore.mercadox.library.entity.model.enums.ConversationStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "conversation", schema = "ai")
public class Conversation extends TenantBaseEntity {

    @Id
    private UUID id;

    @Column(name = "channel", nullable = false)
    @Enumerated(EnumType.STRING)
    private ConversationChannel channel;

    @Column(name = "external_contact_id", nullable = false)
    private String externalContactId;

    @Column(name = "lead_id")
    private UUID leadId;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ConversationStatus status;

    @Column(name = "last_inbound_at")
    private Instant lastInboundAt;

    public static Conversation startNew(
            ConversationChannel channel,
            String externalContactId
    ) {
        Conversation conv = new Conversation();
        conv.id = UUID.randomUUID();
        conv.channel = channel;
        conv.externalContactId = externalContactId;
        conv.status = ConversationStatus.ACTIVE;
        conv.lastInboundAt = Instant.now();
        return conv;
    }

    public void stampInbound() {
        this.lastInboundAt = Instant.now();
    }

}
