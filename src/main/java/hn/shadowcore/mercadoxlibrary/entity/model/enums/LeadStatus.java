package hn.shadowcore.mercadoxlibrary.entity.model.enums;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum LeadStatus {

    NEW(0),
    CONTACTED(1),
    QUALIFIED(2),
    CONVERTED(3),

    REOPENED(4),
    REJECTED(-1);

    private final int statusCode;

}
