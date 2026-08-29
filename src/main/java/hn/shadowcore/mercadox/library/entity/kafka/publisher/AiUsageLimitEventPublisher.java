package hn.shadowcore.mercadox.library.entity.kafka.publisher;

import hn.shadowcore.mercadox.library.entity.avro.AiUsageLimitExceededEvent;

public interface AiUsageLimitEventPublisher {

    void publishUsageLimitExceeded(AiUsageLimitExceededEvent event);

}
