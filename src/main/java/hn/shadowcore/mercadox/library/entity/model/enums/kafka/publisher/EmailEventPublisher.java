package hn.shadowcore.mercadox.library.entity.model.enums.kafka.publisher;

import hn.shadowcore.mercadox.library.entity.response.dto.EmailEventDto;

public interface EmailEventPublisher {

    void publishOrderPlaced(EmailEventDto<?> event);

    void publishOrderDispatch(EmailEventDto<?> event);

    void publishOrderCancelled(EmailEventDto<?> event);

}
