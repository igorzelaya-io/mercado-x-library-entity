package hn.shadowcore.mercadox.library.entity.model.ai;

import hn.shadowcore.mercadox.library.entity.model.enums.MessageRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "conversation_message", schema = "ai")
public class ConversationMessage {

    @Id
    private UUID id;

    @Column(name = "conversation_id", nullable = false)
    private UUID conversationId;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private MessageRole role;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "anthropic_message_id")
    private String anthropicMessageId;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    public static ConversationMessage of(
            UUID conversationId,
            MessageRole role,
            String content,
            String anthropicMessageId
    ) {
        ConversationMessage msg = new ConversationMessage();
        msg.id = UUID.randomUUID();
        msg.conversationId = conversationId;
        msg.role = role;
        msg.content = content;
        msg.anthropicMessageId = anthropicMessageId;
        msg.createdAt = Instant.now();
        return msg;
    }

}
