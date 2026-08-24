package hn.shadowcore.mercadox.library.entity.model.ai;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organization_whatsapp_config", schema = "ai")
public class OrganizationWhatsAppConfig {

    @Id
    private UUID id;

    @Column(name = "organization_id", nullable = false)
    private UUID organizationId;

    @Column(name = "phone_number_id", nullable = false, unique = true)
    private String phoneNumberId;

    @Column(name = "waba_id", nullable = false)
    private String wabaId;

    @Column(name = "ai_enabled", nullable = false)
    private boolean aiEnabled;

    @Column(name = "access_token", nullable = false)
    private String accessToken;

    @Column(name = "default_reengagement_template")
    private String defaultReengagementTemplate;

    public static OrganizationWhatsAppConfig create(
            UUID organizationId,
            String phoneNumberId,
            String wabaId,
            String accessToken,
            String defaultReengagementTemplate
    ) {
        OrganizationWhatsAppConfig config = new OrganizationWhatsAppConfig();
        config.id = UUID.randomUUID();
        config.organizationId = organizationId;
        config.phoneNumberId = phoneNumberId;
        config.wabaId = wabaId;
        config.accessToken = accessToken;
        config.aiEnabled = false;
        config.defaultReengagementTemplate = defaultReengagementTemplate;
        return config;
    }

}
