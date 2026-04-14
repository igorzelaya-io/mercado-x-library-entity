package hn.shadowcore.mercadox.library.entity.model.enums.kafka.publisher;

import hn.shadowcore.mercadox.library.entity.response.EventDto;
import hn.shadowcore.mercadox.library.entity.response.dto.EmailEventDto;

public interface EmailEventPublisher {

    void publishOrderPlaced(EventDto<EmailEventDto<?>> event);

    void publishOrderDispatch(EventDto<EmailEventDto<?>> event);

    void publishOrderCancelled(EventDto<EmailEventDto<?>> event);

}
