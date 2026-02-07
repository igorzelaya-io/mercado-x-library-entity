package hn.shadowcore.mercadoxlibrary.entity.model.core;

import hn.shadowcore.mercadoxlibrary.entity.model.TenantBaseEntity;
import hn.shadowcore.mercadoxlibrary.entity.model.auth.Organization;
import hn.shadowcore.mercadoxlibrary.entity.model.enums.TemplateChannel;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;

@Entity @Table(name = "notification_template", schema = "core")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationTemplate extends TenantBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "template_seq")
    @SequenceGenerator(name = "template_seq", sequenceName = "core.notification_template_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "channel", nullable = false)
    @Enumerated(EnumType.STRING)
    private TemplateChannel templateChannel;

    @Column(name = "language_code", nullable = false)
    private String languageCode;

    @ManyToOne
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;

    @Column(name = "whatsapp_template_name")
    private String whatsappTemplateName;

    @Column
    private String subject;

    @Lob
    @Column(name = "body_html", columnDefinition = "TEXT")
    private String bodyHtml;

    @Column
    private Boolean active;

    @Column(name = "system_template")
    private Boolean systemTemplate;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ElementCollection
    @CollectionTable(
            name = "notification_template_variables",
            joinColumns = @JoinColumn(name = "notification_template_id")
    )
    @Column(name = "variable", length = 255)
    private Set<String> variables;

    public void setOrganization(Organization organization) {
        this.organization = organization;
        this.setOrgId(organization.getId());
    }
}
