package hn.shadowcore.mercadoxlibrary.entity.model.invoicing;

import hn.shadowcore.mercadoxlibrary.entity.model.auth.Branch;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "invoice_range", schema = "invoicing") @Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "approved_range_prefix")
    private String approvedRangePrefix;

    @Column(name = "range_due_date")
    private Timestamp rangeDueDate;

    @Column(name = "range_start", nullable = false)
    private Integer rangeStart;

    @Column(name = "range_current", nullable = false)
    private Integer rangeCurrent;

    @Column(name = "range_end", nullable = false)
    private Integer rangeEnd;

    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    private Branch branch;

}
