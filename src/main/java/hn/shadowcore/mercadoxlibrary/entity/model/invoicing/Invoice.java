package hn.shadowcore.mercadoxlibrary.entity.model.invoicing;


import hn.shadowcore.mercadoxlibrary.entity.model.auth.Organization;
import hn.shadowcore.mercadoxlibrary.entity.model.auth.User;
import hn.shadowcore.mercadoxlibrary.entity.model.core.Item;
import hn.shadowcore.mercadoxlibrary.entity.model.core.Shipment;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table
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

    @OneToMany(mappedBy = "invoice")
    private List<Item> items;

}
