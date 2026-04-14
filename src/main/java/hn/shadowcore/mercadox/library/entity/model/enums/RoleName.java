package hn.shadowcore.mercadox.library.entity.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleName {

    USER("ROLE_USER"), ORG_ADMIN("ROLE_ORG_ADMIN"), ADMIN("ROLE_ADMIN");

    private final String value;

}
