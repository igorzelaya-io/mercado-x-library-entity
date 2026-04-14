package hn.shadowcore.mercadox.library.entity.model.auth;


import hn.shadowcore.mercadox.library.entity.model.core.Location;
import hn.shadowcore.mercadox.library.entity.model.core.Order;
import hn.shadowcore.mercadox.library.entity.model.enums.UserTypeName;
import hn.shadowcore.mercadox.library.entity.model.TenantBaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity @Table(name = "users", schema = "auth")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder(toBuilder = true)
@FilterDef(name = "enabledEntityFilter", parameters = @ParamDef(name = "enabled", type = Boolean.class))
@Filter(name = "enabledEntityFilter", condition = "enabled = :enabled")
@Filter(name = "orgIdFilter", condition = "org_id = :orgId")
public class User extends TenantBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @Column(name = "is_admin", nullable = false)
    private Boolean isAdmin = false;

    @Column(name = "drive_available")
    private Boolean driveAvailable;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_type_id")
    private UserType userType;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organization organization;

    @OneToMany(mappedBy = "user")
    private List<Order> order;

    @OneToMany(mappedBy = "user")
    private List<AuditLog> userLogs;

    @OneToMany(mappedBy = "user")
    private List<Location> deliveryLocation;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            schema = "auth",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> userRoles = new HashSet<>();

    public void setOrganization(Organization organization) {
        this.organization = organization;
        this.setOrgId(organization.getId());
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public static User buildStaticTestUser() {
        return User.builder()
                .username("testuser")
                .firstName("Testing").lastName("Davidson").email("a@test.com")
                .password("test").phoneNumber("0000-0000").enabled(true)
                .createdAt(Timestamp.valueOf(LocalDateTime.now()))
                .isAdmin(false)
                .userType(UserType.builder()
                        .name(UserTypeName.BUYER)
                        .build())
                .organization(Organization.buildStaticTestOrg())

                .build();
    }

}
