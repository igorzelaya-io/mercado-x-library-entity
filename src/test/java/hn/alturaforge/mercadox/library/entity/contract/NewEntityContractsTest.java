package hn.alturaforge.mercadox.library.entity.contract;

import hn.alturaforge.mercadox.library.entity.crypto.MasterKeyOperationException;
import hn.alturaforge.mercadox.library.entity.kafka.KafkaTopic;
import hn.alturaforge.mercadox.library.entity.kafka.event.DomainEvent;
import hn.alturaforge.mercadox.library.entity.model.appointments.GoogleOAuthAuthorizationTransaction;
import hn.alturaforge.mercadox.library.entity.model.enums.ConversationChannel;
import hn.alturaforge.mercadox.library.entity.model.enums.ConversationStatus;
import hn.alturaforge.mercadox.library.entity.model.enums.GoogleCalendarAuthorizationPurpose;
import hn.alturaforge.mercadox.library.entity.model.enums.GoogleCalendarConnectionStatus;
import hn.alturaforge.mercadox.library.entity.model.enums.MessageRole;
import hn.alturaforge.mercadox.library.entity.model.enums.SendMode;
import hn.alturaforge.mercadox.library.entity.model.enums.SubscriptionPlan;
import hn.alturaforge.mercadox.library.entity.request.ClientLeadRequest;
import hn.alturaforge.mercadox.library.entity.request.appointments.StartGoogleCalendarConnectionRequest;
import hn.alturaforge.mercadox.library.entity.request.webhook.WhatsAppWebhookPayload;
import hn.alturaforge.mercadox.library.entity.response.dto.appointments.GoogleCalendarAuthorizationStart;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class NewEntityContractsTest {

    @Test
    void leadRequestRetainsAllPublicFormFields() {
        ClientLeadRequest request = new ClientLeadRequest(
                "Igor", "Altura Forge", "igor@example.com", "+504 9999-0000", "Build it", "");

        assertThat(request.getUserName()).isEqualTo("Igor");
        assertThat(request.getOrgName()).isEqualTo("Altura Forge");
        assertThat(request.getEmail()).isEqualTo("igor@example.com");
        assertThat(request.getPhoneNumber()).isEqualTo("+504 9999-0000");
        assertThat(request.getMessage()).isEqualTo("Build it");
        assertThat(request.getWebsite()).isEmpty();
    }

    @Test
    void appointmentRecordsRetainAuthorizationContext() {
        UUID orgId = UUID.randomUUID();
        Instant createdAt = Instant.parse("2026-09-10T12:00:00Z");
        Instant expiresAt = createdAt.plusSeconds(600);
        GoogleOAuthAuthorizationTransaction transaction = new GoogleOAuthAuthorizationTransaction(
                orgId, "admin@example.com", "/settings/calendar",
                GoogleCalendarAuthorizationPurpose.CONNECT, createdAt, expiresAt);
        StartGoogleCalendarConnectionRequest request =
                new StartGoogleCalendarConnectionRequest("/settings/calendar");
        GoogleCalendarAuthorizationStart response = new GoogleCalendarAuthorizationStart(
                URI.create("https://accounts.google.com/o/oauth2/auth"), expiresAt,
                GoogleCalendarAuthorizationPurpose.CONNECT);

        assertThat(transaction.orgId()).isEqualTo(orgId);
        assertThat(transaction.administratorEmail()).isEqualTo("admin@example.com");
        assertThat(transaction.returnPath()).isEqualTo(request.returnPath());
        assertThat(transaction.purpose()).isEqualTo(response.purpose());
        assertThat(transaction.createdAt()).isEqualTo(createdAt);
        assertThat(transaction.expiresAt()).isEqualTo(response.expiresAt());
        assertThat(response.authorizationUrl()).hasHost("accounts.google.com");
    }

    @Test
    void webhookRecordsRetainTheMetaEnvelope() {
        WhatsAppWebhookPayload.Message message = new WhatsAppWebhookPayload.Message(
                "wamid-1", "+50499990000", "123", "text",
                new WhatsAppWebhookPayload.Text("hello"));
        WhatsAppWebhookPayload.Metadata metadata =
                new WhatsAppWebhookPayload.Metadata("+50422220000", "phone-id");
        WhatsAppWebhookPayload.Status status = new WhatsAppWebhookPayload.Status(
                "wamid-1", "delivered", "124", "+50499990000");
        WhatsAppWebhookPayload.Value value = new WhatsAppWebhookPayload.Value(
                "whatsapp", metadata, List.of(message), List.of(status));
        WhatsAppWebhookPayload.Change change = new WhatsAppWebhookPayload.Change(value, "messages");
        WhatsAppWebhookPayload.Entry entry =
                new WhatsAppWebhookPayload.Entry("entry-id", List.of(change));
        WhatsAppWebhookPayload payload =
                new WhatsAppWebhookPayload("whatsapp_business_account", List.of(entry));

        assertThat(payload.object()).isEqualTo("whatsapp_business_account");
        assertThat(payload.entry()).containsExactly(entry);
        assertThat(entry.id()).isEqualTo("entry-id");
        assertThat(entry.changes()).containsExactly(change);
        assertThat(change.field()).isEqualTo("messages");
        assertThat(change.value()).isEqualTo(value);
        assertThat(value.messagingProduct()).isEqualTo("whatsapp");
        assertThat(value.metadata()).isEqualTo(metadata);
        assertThat(value.messages()).containsExactly(message);
        assertThat(value.statuses()).containsExactly(status);
        assertThat(metadata.displayPhoneNumber()).isEqualTo("+50422220000");
        assertThat(metadata.phoneNumberId()).isEqualTo("phone-id");
        assertThat(message.id()).isEqualTo("wamid-1");
        assertThat(message.from()).isEqualTo("+50499990000");
        assertThat(message.timestamp()).isEqualTo("123");
        assertThat(message.type()).isEqualTo("text");
        assertThat(message.text().body()).isEqualTo("hello");
        assertThat(status.id()).isEqualTo("wamid-1");
        assertThat(status.status()).isEqualTo("delivered");
        assertThat(status.timestamp()).isEqualTo("124");
        assertThat(status.recipientId()).isEqualTo("+50499990000");
    }

    @Test
    void domainEventRetainsTransportMetadata() {
        TestDomainEvent event = new TestDomainEvent();
        event.setEventId("event-1");
        event.setEventType("TEST_EVENT");
        event.setOrgId("org-1");
        event.setOccurredAt("2026-09-10T12:00:00Z");

        assertThat(event.getEventId()).isEqualTo("event-1");
        assertThat(event.getEventType()).isEqualTo("TEST_EVENT");
        assertThat(event.getOrgId()).isEqualTo("org-1");
        assertThat(event.getOccurredAt()).isEqualTo("2026-09-10T12:00:00Z");
    }

    @Test
    void newEnumsAndTopicConstantsExposeStableWireValues() {
        assertThat(ConversationChannel.values()).containsExactly(ConversationChannel.EMAIL,
                ConversationChannel.WHATSAPP);
        assertThat(ConversationStatus.values()).containsExactly(ConversationStatus.ACTIVE,
                ConversationStatus.CLOSED);
        assertThat(GoogleCalendarAuthorizationPurpose.values()).containsExactly(
                GoogleCalendarAuthorizationPurpose.CONNECT, GoogleCalendarAuthorizationPurpose.REAUTHORIZE);
        assertThat(GoogleCalendarConnectionStatus.values()).containsExactly(
                GoogleCalendarConnectionStatus.ACTIVE, GoogleCalendarConnectionStatus.REAUTH_REQUIRED,
                GoogleCalendarConnectionStatus.REVOKED);
        assertThat(MessageRole.values()).containsExactly(MessageRole.USER, MessageRole.ASSISTANT, MessageRole.TOOL);
        assertThat(SendMode.values()).isNotEmpty();
        assertThat(SubscriptionPlan.values()).isNotEmpty();
        assertThat(KafkaTopic.WHATSAPP_MESSAGE_RECEIVED).isEqualTo("whatsapp.inbound.v1");
        assertThat(KafkaTopic.AI_REPLY_GENERATED).isEqualTo("ai.reply.generated.v1");
        assertThat(KafkaTopic.AI_USAGE_LIMIT_EXCEEDED).isEqualTo("ai.usage.limit.exceeded.v1");
    }

    @Test
    void masterKeyExceptionRetainsCause() {
        IllegalStateException cause = new IllegalStateException("kms unavailable");
        MasterKeyOperationException exception = new MasterKeyOperationException("decrypt failed", cause);

        assertThat(exception).hasMessage("decrypt failed").hasCause(cause);
    }

    private static final class TestDomainEvent extends DomainEvent {
    }
}
