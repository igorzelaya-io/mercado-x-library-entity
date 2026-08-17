package hn.shadowcore.mercadox.library.entity.model.enums.kafka.publisher;

import hn.shadowcore.mercadox.library.entity.avro.LeadCreatedEvent;

public interface LeadEventPublisher {

    void publishLeadCreated(LeadCreatedEvent event);

}
