package hn.shadowcore.mercadoxlibrary.entity.model.enums.kafka.publisher;

import hn.shadowcore.mercadoxlibrary.entity.response.EventDto;
import hn.shadowcore.mercadoxlibrary.entity.response.dto.EmailEventDto;

public interface EmailEventPublisher {

    void publishOrderPlaced(EventDto<EmailEventDto<?>> event);

    void publishOrderDispatch(EventDto<EmailEventDto<?>> event);

    void publishOrderCancelled(EventDto<EmailEventDto<?>> event);

}
