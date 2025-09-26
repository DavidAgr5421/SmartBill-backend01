package sena.facturacion.infrastructure.adapters.input.rest.model.request.Bill;

import lombok.*;

import java.math.BigInteger;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
public class BillDetailSearchRequest {
    private Long billId;
    private Long productId;
    private String productName;
    private BigInteger startAmount;
    private BigInteger endAmount;
    private Long startSubTotal;
    private Long endSubTotal;
}
