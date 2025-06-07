package hn.shadowcore.mercadoxlibrary.entity.model.auth;


import hn.shadowcore.mercadoxlibrary.entity.model.core.Item;
import hn.shadowcore.mercadoxlibrary.entity.model.core.Service;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "organization", schema = "auth")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @OneToMany(mappedBy = "organization")
    private List<User> orgUsers;

    @OneToMany(mappedBy = "organization")
    private List<Branch> orgBranches;

    @OneToMany(mappedBy = "organization")
    private List<Service> services;

    @OneToMany(mappedBy = "organization")
    private List<Item> items;

}
