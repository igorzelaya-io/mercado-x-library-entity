package hn.shadowcore.mercadox.library.entity.kafka.publisher;

import hn.shadowcore.mercadox.library.entity.avro.LeadCreatedEvent;

public interface LeadEventPublisher {

    void publishLeadCreated(LeadCreatedEvent event);

}
