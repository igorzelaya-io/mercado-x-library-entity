package hn.shadowcore.mercadoxlibrary.entity.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

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

}
