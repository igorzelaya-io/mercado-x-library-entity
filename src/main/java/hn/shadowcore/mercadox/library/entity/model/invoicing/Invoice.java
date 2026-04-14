package hn.shadowcore.mercadox.library.entity.model.invoicing;


import hn.shadowcore.mercadox.library.entity.model.auth.Organization;
import hn.shadowcore.mercadox.library.entity.model.auth.User;
import hn.shadowcore.mercadox.library.entity.model.core.Order;
import hn.shadowcore.mercadox.library.entity.model.core.Shipment;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@Table(name = "invoice",  schema = "invoicing")
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal;

    @Column
    private BigDecimal discount;

    @Column(name = "invoice_date", nullable = false)
    private Timestamp invoiceDate;

    @Column(name = "void_due_date")
    private Timestamp voidDueDate;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "invoice_url")
    private String invoiceUrl;

    @Column(nullable = false)
    private BigDecimal tax1;

    @Column
    private BigDecimal tax2;

    @Column
    private BigDecimal tax3;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "org_id", referencedColumnName = "id")
    private Organization organization;

    @OneToOne
    @JoinColumn(name = "shipping_id", referencedColumnName = "id")
    private Shipment shipping;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

}
