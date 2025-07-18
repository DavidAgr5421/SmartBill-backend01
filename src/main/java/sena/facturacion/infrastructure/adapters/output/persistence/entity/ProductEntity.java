package sena.facturacion.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String referenceNo;
    private BigInteger amount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
