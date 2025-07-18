package hn.shadowcore.mercadoxlibrary.entity.model.core;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@Data
@Embeddable
@EqualsAndHashCode
public class OrderItemsKey implements Serializable {

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "order_id")
    private String orderId;

}
