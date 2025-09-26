package sena.facturacion.infrastructure.adapters.input.rest.model.request.Bill;

import lombok.*;

import java.math.BigInteger;

@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class BillDetailPutRequest {

    private Long productId;

    private BigInteger amount;

    private Long subTotal;

    private String observation;
}
