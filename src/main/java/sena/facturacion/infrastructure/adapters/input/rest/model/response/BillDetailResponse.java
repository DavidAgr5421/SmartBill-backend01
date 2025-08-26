package sena.facturacion.infrastructure.adapters.input.rest.model.response;

import lombok.*;

import java.math.BigInteger;

@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class BillDetailResponse {
    private Long id;

    private Long billId;

    private Long productId;

    private BigInteger amount;

    private Long subTotal;

    private String observation;
}
