package hn.shadowcore.mercadoxlibrary.entity.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserTypeName {

    BUYER(0),

    SELLER(1),

    DRIVER(2),

    ADMIN(3),

    SUPER_ADMIN(4);

    private final int typeKey;

}
