package hn.shadowcore.mercadox.library.entity.model.core;


import hn.shadowcore.mercadox.library.entity.model.auth.Organization;
import hn.shadowcore.mercadox.library.entity.model.enums.LeadStatus;
import hn.shadowcore.mercadox.library.entity.model.TenantBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Table(name = "leads", schema = "core")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Lead extends TenantBaseEntity {

    @Id
    private UUID id;

    @Column(name = "lead_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private LeadStatus leadStatus;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "org_name", nullable = false)
    private String orgName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    @ManyToOne(optional = false)
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;

    public static Lead createNew(
            String userName,
            String orgName,
            String email,
            String phoneNumber,
            String message,
            Organization organization
    ) {
        Lead lead = new Lead();
        lead.id = UUID.randomUUID();
        lead.leadStatus = LeadStatus.NEW;
        lead.userName = userName;
        lead.orgName = orgName;
        lead.email = email;
        lead.phoneNumber = phoneNumber;
        lead.message = message;
        lead.organization = organization;
        return lead;
    }

}
