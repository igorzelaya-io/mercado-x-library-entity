package hn.shadowcore.mercadox.library.entity.request.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Mirrors the Meta WhatsApp Cloud API webhook envelope.
 * All fields are nullable — Meta sends different shapes for messages vs. status updates.
 * Unknown fields are ignored so future Meta additions don't break deserialization.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record WhatsAppWebhookPayload(

        String object,
        List<Entry> entry

) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Entry(
            String id,
            List<Change> changes
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Change(
            Value value,
            String field
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Value(
            @JsonProperty("messaging_product") String messagingProduct,
            Metadata metadata,
            List<Message> messages,
            List<Status> statuses
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Metadata(
            @JsonProperty("display_phone_number") String displayPhoneNumber,
            @JsonProperty("phone_number_id") String phoneNumberId
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Message(
            String id,
            String from,
            String timestamp,
            String type,
            Text text
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Text(String body) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Status(
            String id,
            String status,
            String timestamp,
            @JsonProperty("recipient_id") String recipientId
    ) {}
}
