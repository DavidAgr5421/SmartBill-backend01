package sena.facturacion.infrastructure.adapters.input.rest.model.request;

import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProductSearchRequest {

    private String name;
    private String referenceNo;
    private BigInteger amount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
