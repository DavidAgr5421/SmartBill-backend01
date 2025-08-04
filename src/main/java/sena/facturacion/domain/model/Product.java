package sena.facturacion.domain.model;

import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Builder
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String referenceNo;
    private BigInteger amount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(Long id){
        this.id = id;
    }
}
