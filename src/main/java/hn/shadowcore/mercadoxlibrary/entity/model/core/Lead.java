package hn.shadowcore.mercadoxlibrary.entity.model.core;


import hn.shadowcore.mercadoxlibrary.entity.model.enums.LeadStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@Table(name = "leads", schema = "core")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lead {

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

    public static Lead createNew(
            String userName,
            String orgName,
            String email,
            String phoneNumber,
            String message
    ) {
        Lead lead = new Lead();
        lead.id = UUID.randomUUID();
        lead.leadStatus = LeadStatus.NEW;
        lead.userName = userName;
        lead.orgName = orgName;
        lead.email = email;
        lead.phoneNumber = phoneNumber;
        lead.message = message;
        return lead;
    }

}
