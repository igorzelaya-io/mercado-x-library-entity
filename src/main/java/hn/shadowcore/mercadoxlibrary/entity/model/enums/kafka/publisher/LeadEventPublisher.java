package hn.shadowcore.mercadoxlibrary.entity.model.enums.kafka.publisher;

import hn.shadowcore.mercadoxlibrary.entity.model.enums.kafka.event.LeadCreatedEvent;
import hn.shadowcore.mercadoxlibrary.entity.response.EventDto;

public interface LeadEventPublisher {

    void publishLeadCreated(EventDto<LeadCreatedEvent> leadCreatedEvent);

}
