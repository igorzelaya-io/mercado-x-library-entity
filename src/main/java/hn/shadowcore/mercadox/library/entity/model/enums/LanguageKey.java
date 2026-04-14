package hn.shadowcore.mercadox.library.entity.model.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LanguageKey {

    ENGLISH("EN_US"),
    SPANISH_MEX("ES_MX");

    private final String name;

}
