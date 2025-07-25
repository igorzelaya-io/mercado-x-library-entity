package hn.shadowcore.mercadoxlibrary.entity.model.core;

import hn.shadowcore.mercadoxlibrary.entity.model.auth.Branch;
import hn.shadowcore.mercadoxlibrary.entity.model.auth.User;
import jakarta.persistence.CascadeType;
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

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "location", schema = "core")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String locationReference;

    @OneToMany(mappedBy = "location")
    private List<Shipment> shipment;

    @OneToOne(mappedBy = "location")
    private Branch branch;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
