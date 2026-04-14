package hn.shadowcore.mercadox.library.entity.model.enums.kafka;

import lombok.Getter;

@Getter
public final class KafkaTopic {

    //Order
    public static final String USER_REGISTRATION = "user.registration.validation";

    public static final String ORDER_PLACING = "order.operation.place";

    public static final String ORDER_CONFIRMED = "order.operation.confirm";

    public static final String ORDER_CLOSED = "order.operation.closed";

    public static final String ORDER_CANCELLED = "order.operation.cancelled";

    //Lead
    public static final String LEAD_CREATED = "lead.created.v1";

}
