package hn.alturaforge.mercadox.library.entity.kafka.publisher;

import hn.alturaforge.mercadox.library.entity.avro.AiReplyGeneratedEvent;

public interface AiReplyEventPublisher {

    void publishReplyGenerated(AiReplyGeneratedEvent event);

}
