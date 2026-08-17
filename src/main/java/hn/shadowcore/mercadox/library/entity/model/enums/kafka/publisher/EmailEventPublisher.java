package hn.shadowcore.mercadox.library.entity.model.enums.kafka.publisher;

import hn.shadowcore.mercadox.library.entity.avro.OrderEmailEvent;

public interface EmailEventPublisher {

    void publishOrderPlaced(OrderEmailEvent event);

    void publishOrderDispatch(OrderEmailEvent event);

    void publishOrderCancelled(OrderEmailEvent event);

}
