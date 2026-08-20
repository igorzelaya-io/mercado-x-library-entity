package hn.shadowcore.mercadox.library.entity.kafka.publisher;

import hn.shadowcore.mercadox.library.entity.avro.WhatsAppMessageReceivedEvent;

public interface WhatsAppEventPublisher {

    void publishMessageReceived(WhatsAppMessageReceivedEvent event);

}
