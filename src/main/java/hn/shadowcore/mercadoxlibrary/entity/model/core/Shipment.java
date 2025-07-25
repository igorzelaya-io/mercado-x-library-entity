package hn.shadowcore.mercadoxlibrary.entity.model.core;

import hn.shadowcore.mercadoxlibrary.entity.model.auth.User;
import hn.shadowcore.mercadoxlibrary.entity.model.enums.OrderStatus;
import hn.shadowcore.mercadoxlibrary.entity.model.enums.ShippingStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "shipment", schema = "core")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @Column(name = "placedAt")
    private Timestamp placedAt;

    @Column(name = "delivered_at")
    private Timestamp deliveredAt;

    @Column(name = "shipment_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus shipmentStatus;

    @OneToOne(mappedBy = "shipment")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private User deliveryEmployee;

}
