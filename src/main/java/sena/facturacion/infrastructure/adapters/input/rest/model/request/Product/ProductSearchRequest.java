package sena.facturacion.infrastructure.adapters.input.rest.model.request.Product;

import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProductSearchRequest {

    private String name;
    private String referenceNo;
    private BigInteger startAmount;
    private BigInteger endAmount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean active;
}
