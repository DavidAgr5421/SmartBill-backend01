package sena.facturacion.infrastructure.adapters.input.rest.model.request.Bill;

import lombok.*;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class BillPutRequest {

    private Long userId;
    private Long clientId;
    private Long total;
    private String paymentMethod;

}
