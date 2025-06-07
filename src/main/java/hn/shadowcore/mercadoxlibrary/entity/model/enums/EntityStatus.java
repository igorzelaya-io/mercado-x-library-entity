package hn.shadowcore.mercadoxlibrary.entity.model.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EntityStatus {

    INACTIVE(0),
    ACTIVE(1);

    private final int statusCode;
}
