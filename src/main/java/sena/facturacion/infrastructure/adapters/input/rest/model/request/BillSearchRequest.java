package sena.facturacion.infrastructure.adapters.input.rest.model.request;


import lombok.*;

import java.time.LocalDateTime;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class BillSearchRequest {

    private Long billId;
    private Long userId;
    private Long clientId;
    private String productName;

    private Long startTotal;
    private Long endTotal;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private String paymentMethod;
}
