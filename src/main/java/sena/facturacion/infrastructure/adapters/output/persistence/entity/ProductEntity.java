package sena.facturacion.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String referenceNo;
    private BigInteger amount;
    private Long unitPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
