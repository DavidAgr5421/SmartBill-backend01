package sena.facturacion.infrastructure.adapters.input.rest.model.response.Product;

import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private String referenceNo;
    private BigInteger amount;
    private Long unitPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean active;
}
