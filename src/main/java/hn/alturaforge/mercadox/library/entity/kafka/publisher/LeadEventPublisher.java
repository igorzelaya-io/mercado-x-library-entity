package hn.alturaforge.mercadox.library.entity.kafka.publisher;

import hn.alturaforge.mercadox.library.entity.avro.LeadCreatedEvent;

public interface LeadEventPublisher {

    void publishLeadCreated(LeadCreatedEvent event);

}
