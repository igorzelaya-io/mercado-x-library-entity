package hn.shadowcore.mercadox.library.entity.model.enums.kafka.publisher;

import hn.shadowcore.mercadox.library.entity.model.enums.kafka.event.LeadCreatedEvent;
import hn.shadowcore.mercadox.library.entity.response.EventDto;

public interface LeadEventPublisher {

    void publishLeadCreated(EventDto<LeadCreatedEvent> leadCreatedEvent);

}
