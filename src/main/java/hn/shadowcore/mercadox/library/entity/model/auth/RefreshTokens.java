package hn.shadowcore.mercadox.library.entity.model.auth;


import hn.shadowcore.mercadox.library.entity.model.TenantBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "refresh_tokens", schema = "auth")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefreshTokens extends TenantBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refresh_token_seq_gen")
    @SequenceGenerator(name = "refresh_token_seq_gen",
            sequenceName = "auth.refresh_token_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "expires_at", nullable = false)
    private Timestamp expiresAt;

}
