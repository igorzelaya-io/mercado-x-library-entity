package hn.shadowcore.mercadoxlibrary.entity.model.enums;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ShippingStatus {
    UNDER_REVIEW(0),

    PLACED(1),
    IN_PROGRESS(2),

    DELIVERED(3),
    CANCELED(4);

    private final int statusCode;
}
