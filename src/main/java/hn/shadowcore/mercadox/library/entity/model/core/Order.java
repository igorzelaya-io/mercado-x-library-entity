package hn.shadowcore.mercadox.library.entity.model.core;


import hn.shadowcore.mercadox.library.entity.model.enums.OrderStatus;
import hn.shadowcore.mercadox.library.entity.model.TenantBaseEntity;
import hn.shadowcore.mercadox.library.entity.model.auth.Organization;
import hn.shadowcore.mercadox.library.entity.model.auth.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "orders", schema = "core")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order extends TenantBaseEntity {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    private Organization organization;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Set<OrderItem> items = new HashSet<>();

    public void setOrganization(Organization organization) {
        this.organization = organization;
        this.setOrgId(organization.getId());
    }

    public static String generateId() {
        String timestamp = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        String suffix = UUID.randomUUID().toString().substring(0, 5).toUpperCase();
        return new StringBuilder("ORD-").append(timestamp).append("-").append(suffix).toString();
    }

}