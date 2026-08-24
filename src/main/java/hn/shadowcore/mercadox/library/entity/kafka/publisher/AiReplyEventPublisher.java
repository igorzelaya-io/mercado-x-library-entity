package hn.shadowcore.mercadox.library.entity.kafka.publisher;

import hn.shadowcore.mercadox.library.entity.avro.AiReplyGeneratedEvent;

public interface AiReplyEventPublisher {

    void publishReplyGenerated(AiReplyGeneratedEvent event);

}
