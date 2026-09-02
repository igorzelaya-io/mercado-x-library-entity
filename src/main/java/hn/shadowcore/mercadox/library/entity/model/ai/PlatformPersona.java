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

/**
 * Tenant-independent persona paragraphs — apply to every organization. Composed
 * ahead of an org's own OrganizationPersona rows to form the full Claude system
 * prompt (platform rows first, then org-specific rows).
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "platform_persona", schema = "ai")
public class PlatformPersona {

    @Id
    private UUID id;

    @Column(name = "persona_key", nullable = false, unique = true)
    private String personaKey;

    @Column(name = "prompt_text", nullable = false, columnDefinition = "TEXT")
    private String promptText;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public static PlatformPersona create(String personaKey, String promptText) {
        PlatformPersona persona = new PlatformPersona();
        persona.id = UUID.randomUUID();
        persona.personaKey = personaKey;
        persona.promptText = promptText;
        persona.active = true;
        Instant now = Instant.now();
        persona.createdAt = now;
        persona.updatedAt = now;
        return persona;
    }

}
