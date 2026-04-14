package hn.shadowcore.mercadox.library.entity.model.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PaymentStatus {

    IN_PROGRESS(0),
    ACCEPTED(1),
    DECLINED(2);

    private final int statusCode;

}
