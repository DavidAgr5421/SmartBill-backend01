package sena.facturacion.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_rol")
public class UserRolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolId;

    @Column(name = "rol_name")
    private String rolName;

}
