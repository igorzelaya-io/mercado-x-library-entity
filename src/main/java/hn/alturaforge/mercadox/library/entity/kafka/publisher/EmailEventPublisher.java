package hn.alturaforge.mercadox.library.entity.kafka.publisher;

import hn.alturaforge.mercadox.library.entity.avro.OrderEmailEvent;

public interface EmailEventPublisher {

    void publishOrderPlaced(OrderEmailEvent event);

    void publishOrderDispatch(OrderEmailEvent event);

    void publishOrderCancelled(OrderEmailEvent event);

}
