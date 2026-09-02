package hn.shadowcore.mercadox.library.entity.model.ai;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organization_persona", schema = "ai")
public class OrganizationPersona {

    @Id
    private UUID id;

    @Column(name = "organization_id", nullable = false)
    private UUID organizationId;

    @Column(name = "persona_key", nullable = false)
    private String personaKey;

    @Column(name = "prompt_text", nullable = false, columnDefinition = "TEXT")
    private String promptText;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public static OrganizationPersona create(UUID organizationId, String personaKey, String promptText) {
        OrganizationPersona persona = new OrganizationPersona();
        persona.id = UUID.randomUUID();
        persona.organizationId = organizationId;
        persona.personaKey = personaKey;
        persona.promptText = promptText;
        persona.active = true;
        Instant now = Instant.now();
        persona.createdAt = now;
        persona.updatedAt = now;
        return persona;
    }

}
