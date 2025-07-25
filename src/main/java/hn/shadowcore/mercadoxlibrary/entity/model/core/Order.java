package hn.shadowcore.mercadoxlibrary.entity.model.core;


import hn.shadowcore.mercadoxlibrary.entity.model.TenantBaseEntity;
import hn.shadowcore.mercadoxlibrary.entity.model.auth.Organization;
import hn.shadowcore.mercadoxlibrary.entity.model.auth.User;
import hn.shadowcore.mercadoxlibrary.entity.model.enums.OrderStatus;
import hn.shadowcore.mercadoxlibrary.entity.model.invoicing.Invoice;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "order", schema = "core")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order extends TenantBaseEntity {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "dispatched_by")
    private String dispatchedBy;

    @Column(name = "delivery_id")
    private String deliveryId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organization organization;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private Set<OrderItem> items;

}