package hn.shadowcore.mercadox.library.entity.model.enums.kafka.publisher;

import hn.shadowcore.mercadox.library.entity.model.enums.kafka.event.LeadCreatedEvent;

public interface LeadEventPublisher {

    void publishLeadCreated(LeadCreatedEvent leadCreatedEvent);

}
