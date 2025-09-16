package sena.facturacion.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Report {
    private Long id;
    private User userId;
    private BigDecimal totalSales; // Ventas totales - Se obtiene de los Bills del año (Bill Service)
    private BigDecimal monthSales; // Se obtiene de Bills solo de este mes
    private String observation;
    private BigInteger onLowStockValue; // Se hallan todos los productos actuales que esten debajo de LowValue
    private List<String> productOnStock; //Todos los productos por nombre y cantidad
    private List<String> productOnLowStock; // Product Service
    private LocalDateTime createdAt;
}
