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
    @MapsId
    @JoinColumn(name = "fk_rol_id", insertable = false, updatable = false)
    private UserRolEntity rol;

    @Column(name = "create_bill")
    private Boolean createBill;

    @Column(name = "delete_bill")
    private Boolean deleteBill;

    @Column(name = "view_history")
    private Boolean viewHistory;

    @Column(name = "print_bill")
    private Boolean printBill;

    @Column(name = "create_product")
    private Boolean createProduct;

    @Column(name = "delete_product")
    private Boolean deleteProduct;

    @Column(name = "create_user")
    private Boolean createUser;

    @Column(name = "delete_user")
    private Boolean deleteUser;

    @Column(name = "generate_reports")
    private Boolean generateReports;

    @Column(name = "edit_config")
    private Boolean editConfig;

    @Column(name = "view_config")
    private Boolean viewConfig;

    @Column(name = "create_rol")
    private Boolean createRol;

    @Column(name = "delete_rol")
    private Boolean deleteRol;


}
