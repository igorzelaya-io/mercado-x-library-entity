package hn.alturaforge.mercadox.library.entity.kafka.publisher;

import hn.alturaforge.mercadox.library.entity.avro.WhatsAppMessageReceivedEvent;

public interface WhatsAppEventPublisher {

    void publishMessageReceived(WhatsAppMessageReceivedEvent event);

}
