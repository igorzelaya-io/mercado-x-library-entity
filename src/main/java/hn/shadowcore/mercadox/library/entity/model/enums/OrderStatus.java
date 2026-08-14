package hn.shadowcore.mercadox.library.entity.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {

    UNDER_REVIEW(0),
    IN_PROGRESS(1),
    DELIVERED(2),
    DELAYED(3),
    UNPAID(4),
    CLOSED(5),
    CANCELLED(6);

    private final int value;
    private Set<OrderStatus> allowedTransitions;

    static {
        UNDER_REVIEW.allowedTransitions = Set.of(IN_PROGRESS, CANCELLED);
        IN_PROGRESS.allowedTransitions  = Set.of(DELIVERED, DELAYED, CLOSED, CANCELLED);
        DELIVERED.allowedTransitions    = Set.of(CLOSED, UNPAID);
        DELAYED.allowedTransitions      = Set.of(IN_PROGRESS, CANCELLED);
        UNPAID.allowedTransitions       = Set.of(CANCELLED);
        CLOSED.allowedTransitions       = Set.of();
        CANCELLED.allowedTransitions    = Set.of();
    }

    public OrderStatus transitionTo(OrderStatus next) {
        if (!allowedTransitions.contains(next)) {
            throw new IllegalStateException(
                    String.format("Illegal order transition: %s → %s", this, next));
        }
        return next;
    }

}
