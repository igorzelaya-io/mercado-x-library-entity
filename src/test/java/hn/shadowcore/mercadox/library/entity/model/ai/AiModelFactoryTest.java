package hn.shadowcore.mercadox.library.entity.model.ai;

import hn.shadowcore.mercadox.library.entity.model.enums.ConversationChannel;
import hn.shadowcore.mercadox.library.entity.model.enums.ConversationStatus;
import hn.shadowcore.mercadox.library.entity.model.enums.MessageRole;
import hn.shadowcore.mercadox.library.entity.model.enums.SubscriptionPlan;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class AiModelFactoryTest {

    private static final UUID ORG_ID = UUID.fromString("11111111-1111-1111-1111-111111111111");

    @Test
    void newConversationStartsActiveWithTenantAndInboundTimestamp() {
        Instant before = Instant.now();

        Conversation conversation = Conversation.startNew(
                ORG_ID, ConversationChannel.WHATSAPP, "+50499990000");

        assertThat(conversation.getId()).isNotNull();
        assertThat(conversation.getOrgId()).isEqualTo(ORG_ID);
        assertThat(conversation.getChannel()).isEqualTo(ConversationChannel.WHATSAPP);
        assertThat(conversation.getExternalContactId()).isEqualTo("+50499990000");
        assertThat(conversation.getStatus()).isEqualTo(ConversationStatus.ACTIVE);
        assertThat(conversation.getLastInboundAt()).isAfterOrEqualTo(before);
        assertThat(conversation.getLeadId()).isNull();
        assertThat(conversation.getCorrelationId()).isNull();
    }

    @Test
    void inboundStampRefreshesTimestampWithoutChangingConversationIdentity() {
        Conversation conversation = Conversation.startNew(
                ORG_ID, ConversationChannel.EMAIL, "customer@example.com");
        UUID id = conversation.getId();
        conversation.setLastInboundAt(Instant.EPOCH);

        conversation.stampInbound();

        assertThat(conversation.getLastInboundAt()).isAfter(Instant.EPOCH);
        assertThat(conversation.getId()).isEqualTo(id);
    }

    @Test
    void conversationMessageFactoryPopulatesAuditAndProviderFields() {
        UUID conversationId = UUID.randomUUID();
        Instant before = Instant.now();

        ConversationMessage message = ConversationMessage.of(
                conversationId, MessageRole.ASSISTANT, "Hello", "msg-provider-1");

        assertThat(message.getId()).isNotNull();
        assertThat(message.getConversationId()).isEqualTo(conversationId);
        assertThat(message.getRole()).isEqualTo(MessageRole.ASSISTANT);
        assertThat(message.getContent()).isEqualTo("Hello");
        assertThat(message.getAnthropicMessageId()).isEqualTo("msg-provider-1");
        assertThat(message.getCreatedAt()).isAfterOrEqualTo(before);
    }

    @Test
    void organizationPersonaFactoryCreatesAnActiveSynchronizedRecord() {
        OrganizationPersona persona = OrganizationPersona.create(ORG_ID, "SALES", "Sell helpfully");

        assertThat(persona.getId()).isNotNull();
        assertThat(persona.getOrganizationId()).isEqualTo(ORG_ID);
        assertThat(persona.getPersonaKey()).isEqualTo("SALES");
        assertThat(persona.getPromptText()).isEqualTo("Sell helpfully");
        assertThat(persona.isActive()).isTrue();
        assertThat(persona.getCreatedAt()).isEqualTo(persona.getUpdatedAt());
    }

    @Test
    void platformPersonaFactoryCreatesAnActiveSynchronizedRecord() {
        PlatformPersona persona = PlatformPersona.create("BASE", "Be concise");

        assertThat(persona.getId()).isNotNull();
        assertThat(persona.getPersonaKey()).isEqualTo("BASE");
        assertThat(persona.getPromptText()).isEqualTo("Be concise");
        assertThat(persona.isActive()).isTrue();
        assertThat(persona.getCreatedAt()).isEqualTo(persona.getUpdatedAt());
    }

    @Test
    void whatsAppConfigFactoryUsesSafeStarterDefaults() {
        OrganizationWhatsAppConfig config = OrganizationWhatsAppConfig.create(
                ORG_ID, "phone-id", "waba-id", "encrypted-token", "return_to_chat");

        assertThat(config.getId()).isNotNull();
        assertThat(config.getOrganizationId()).isEqualTo(ORG_ID);
        assertThat(config.getPhoneNumberId()).isEqualTo("phone-id");
        assertThat(config.getWabaId()).isEqualTo("waba-id");
        assertThat(config.getAccessToken()).isEqualTo("encrypted-token");
        assertThat(config.getDefaultReengagementTemplate()).isEqualTo("return_to_chat");
        assertThat(config.getPlan()).isEqualTo(SubscriptionPlan.STARTER);
        assertThat(config.isAiEnabled()).isFalse();
        assertThat(config.isAllowOverage()).isFalse();
    }
}
