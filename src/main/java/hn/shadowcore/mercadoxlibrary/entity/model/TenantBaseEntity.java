package hn.shadowcore.mercadoxlibrary.entity.model;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.util.UUID;


@MappedSuperclass
@FilterDef(name = "orgIdFilter", parameters = @ParamDef(name = "orgId", type = UUID.class))
@Filter(name = "orgIdFilter", condition = "org_id = :org_id")
public abstract class TenantBaseEntity {

    @Column(name = "org_id", insertable = false, updatable = false)
    private UUID orgId;

    public UUID getOrgId() {
        return orgId;
    }
}
