package sena.facturacion.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rol_privileges")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class RolPrivilegesEntity {

    @Id
    private Long rolId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rol_id")
    private UserRolEntity rol;

    private Boolean createBill;

    private Boolean deleteBill;

    private Boolean viewHistory;

    private Boolean printBill;

    private Boolean createProduct;

    private Boolean deleteProduct;

    private Boolean createUser;

    private Boolean deleteUser;

    private Boolean generateReports;

    private Boolean editConfig;

    private Boolean viewConfig;

    private Boolean createRol;

    private Boolean deleteRol;


}
