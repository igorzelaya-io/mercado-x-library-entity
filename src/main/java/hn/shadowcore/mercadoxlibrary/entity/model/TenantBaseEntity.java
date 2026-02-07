package hn.shadowcore.mercadoxlibrary.entity.model;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.util.UUID;

@Data
@MappedSuperclass
@FilterDef(name = "orgIdFilter", parameters = @ParamDef(name = "orgId", type = UUID.class))
public abstract class TenantBaseEntity {

    @Column(name = "org_id", insertable = false, updatable = false)
    private UUID orgId;

}
