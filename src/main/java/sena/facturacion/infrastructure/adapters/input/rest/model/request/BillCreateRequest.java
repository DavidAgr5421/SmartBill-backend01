package sena.facturacion.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.ClientEntity;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.UserEntity;

import java.time.LocalDateTime;

@Builder
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class BillCreateRequest {

    @NotNull(message = "The User ID cannot be null.")
    private UserEntity userId;

    @NotNull(message = "The Client ID cannot be null.")
    private ClientEntity clientId;

    @NotNull(message = "The Total cannot be null.")
    private Long total;
    @NotBlank(message = "The Payment method cannot be blank.")
    private String paymentMethod;
}
