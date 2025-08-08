package sena.facturacion.infrastructure.adapters.input.rest.model.response;

import lombok.*;
import sena.facturacion.domain.model.Bill;
import sena.facturacion.domain.model.Product;

import java.math.BigInteger;

@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class BillDetailResponse {
    private Long id;

    private Long billId;

    private Long productId;

    private BigInteger amount;

    private Long unitPrice;

    private Long unitMeasurement;

    private Long subTotal;

    private String observation;
}
