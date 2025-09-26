package sena.facturacion.infrastructure.adapters.input.rest.model.response.User;

import lombok.*;
import sena.facturacion.domain.model.UserRol;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolPrivilegesResponse {
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

}

