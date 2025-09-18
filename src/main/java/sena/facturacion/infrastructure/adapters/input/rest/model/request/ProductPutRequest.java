package sena.facturacion.infrastructure.adapters.input.rest.model.request;

import lombok.*;

import java.math.BigInteger;

@Builder @Getter
@Setter @AllArgsConstructor @NoArgsConstructor
public class ProductPutRequest {

    private String name;
    private String referenceNo;
    private Long unitPrice;
    private BigInteger amount;
}
