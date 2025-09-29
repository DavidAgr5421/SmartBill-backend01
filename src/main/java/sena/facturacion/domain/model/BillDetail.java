package sena.facturacion.domain.model;

import lombok.*;

import java.math.BigInteger;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class BillDetail {

    private Long id;
    private Bill billId;
    private Product productId; //ESTO SI
    private BigInteger amount; // SISAS

    private Long unitPrice;
    private Long subTotal; // SISA
    private String observation; // SISA
}
