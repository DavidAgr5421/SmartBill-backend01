package sena.facturacion.infrastructure.adapters.input.rest.model.request.User;

import lombok.*;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class RolPrivilegesPutRequest {

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
