package sena.facturacion.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class RolPrivileges {

    private Long rolId;

    private UserRol rol;

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

    public RolPrivileges(UserRol rol){
        this.rol = rol;
        this.rolId = rol.getRolId();
    }
}
