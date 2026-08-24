package hn.shadowcore.mercadox.library.entity.kafka.publisher;

import hn.shadowcore.mercadox.library.entity.avro.OrderEmailEvent;

public interface EmailEventPublisher {

    void publishOrderPlaced(OrderEmailEvent event);

    void publishOrderDispatch(OrderEmailEvent event);

    void publishOrderCancelled(OrderEmailEvent event);

}
