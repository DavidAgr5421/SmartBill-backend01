package sena.facturacion.domain.model;

import lombok.*;

import java.math.BigInteger;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class BillDetail {

    private Bill billId;
    private Product productId;
    private BigInteger amount;
    private Long unitPrice;
    private Long unitMeasurement;
    private Long subTotal;
    private String observation;
}
