package hn.shadowcore.mercadoxlibrary.entity.model.core;


import hn.shadowcore.mercadoxlibrary.entity.model.TenantBaseEntity;
import hn.shadowcore.mercadoxlibrary.entity.model.auth.Organization;
import hn.shadowcore.mercadoxlibrary.entity.model.enums.EntityStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "service_category", schema = "core")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCategory extends TenantBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;

    @OneToMany(mappedBy = "serviceCategory")
    private List<Service> services;

    @Column(name = "entity_status", nullable = false)
    private EntityStatus entityStatus;

}
