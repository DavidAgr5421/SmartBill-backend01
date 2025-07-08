package sena.facturacion.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_rol")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class UserRolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolId;

    @Column(name = "rol_name")
    private String rolName;

    @OneToOne(mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private RolPrivilegesEntity rolPrivileges;
}
