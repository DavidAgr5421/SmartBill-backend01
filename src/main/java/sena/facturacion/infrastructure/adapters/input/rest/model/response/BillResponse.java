package sena.facturacion.infrastructure.adapters.input.rest.model.response;

import lombok.*;

import java.time.LocalDateTime;

@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class BillResponse {

    private Long id;
    private Long userId;
    private String userName;
    private Long clientId;
    private String clientName;
    private Long total;
    private LocalDateTime creationDate;
    private String paymentMethod;

}
