package hn.shadowcore.mercadox.library.entity.model.enums.kafka.event;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize
public abstract class DomainEvent {

    @JsonProperty
    private String eventId;

    @JsonProperty
    private String eventType;

    @JsonProperty
    private String orgId;

    @JsonProperty
    private String occurredAt;

}
