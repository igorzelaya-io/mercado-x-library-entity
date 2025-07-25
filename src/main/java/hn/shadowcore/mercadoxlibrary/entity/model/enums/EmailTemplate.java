package hn.shadowcore.mercadoxlibrary.entity.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EmailTemplate {

    USER_VALIDATION_TEMPLATE("user-validation-template.html"),
    ORDER_REQUEST_TEMPLATE("order-request-template.html"),
    ORDER_CONFIRMATION_TEMPLATE("order-confirmed-template.html"),
    ORDER_CANCELLATION_TEMPLATE("order-cancelled-template.html");

    private final String value;
}
