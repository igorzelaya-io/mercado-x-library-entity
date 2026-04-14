package hn.shadowcore.mercadox.library.entity.model.core;


import hn.shadowcore.mercadox.library.entity.model.TenantBaseEntity;
import hn.shadowcore.mercadox.library.entity.model.auth.Organization;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "category", schema = "core")
@Data @Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Filter(name = "enabledEntityFilter", condition = "enabled = :enabled")
@Filter(name = "orgIdFilter", condition = "org_id = :orgId")
public class Category extends TenantBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organization organization;

    @OneToMany(mappedBy = "category")
    private List<Item> items;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    public void setOrganization(Organization organization) {
        this.organization = organization;
        this.setOrgId(organization.getId());
    }

}
