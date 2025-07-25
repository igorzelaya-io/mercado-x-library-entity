package hn.shadowcore.mercadoxlibrary.entity.model.core;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data @Builder
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsKey implements Serializable {

    @Column(name = "item_id")
    private UUID itemId;

    @Column(name = "order_id")
    private String orderId;

}
