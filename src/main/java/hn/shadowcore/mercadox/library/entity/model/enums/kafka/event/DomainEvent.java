package hn.shadowcore.mercadox.library.entity.model.enums.kafka.event;


import lombok.Data;

@Data
public abstract class DomainEvent {

    private String eventId;

    private String eventType;

    private String orgId;

    private String occurredAt;

}
