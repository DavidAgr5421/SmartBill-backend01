package sena.facturacion.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import sena.facturacion.domain.model.UserRol;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RolPrivilegesCreateRequest {

    @NotNull(message = "The Rol Id cannot be null!")
    private Long rolId;

    @NotBlank(message = "The Rol cannot be blank!")
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
