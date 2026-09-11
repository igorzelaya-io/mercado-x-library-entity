package hn.alturaforge.mercadox.library.entity.kafka.publisher;

import hn.alturaforge.mercadox.library.entity.avro.AiUsageLimitExceededEvent;

public interface AiUsageLimitEventPublisher {

    void publishUsageLimitExceeded(AiUsageLimitExceededEvent event);

}
