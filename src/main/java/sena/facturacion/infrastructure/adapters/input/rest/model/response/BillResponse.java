package sena.facturacion.infrastructure.adapters.input.rest.model.response;

import lombok.*;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.ClientEntity;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.UserEntity;

import java.time.LocalDateTime;

@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class BillResponse {

    private Long id;
    private UserEntity userId;
    private ClientEntity clientId;
    private Long total;
    private LocalDateTime creationDate;
    private String paymentMethod;

}
