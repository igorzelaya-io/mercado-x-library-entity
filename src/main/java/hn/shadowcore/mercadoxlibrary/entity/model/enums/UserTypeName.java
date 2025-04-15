package hn.shadowcore.mercadoxlibrary.entity.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserTypeName {

    BUYER(0),

    SELLER(1),

    ADMIN(2),

    SUPER_ADMIN(3);

    private final int typeKey;

}
