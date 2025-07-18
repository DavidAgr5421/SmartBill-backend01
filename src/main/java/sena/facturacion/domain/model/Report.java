package sena.facturacion.domain.model;

import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Report {
    private Long id;
    private User userId;
    private BigDecimal totalSales;
    private BigDecimal monthSales;
    private String productOnStock;
    private String productOnLowStock;
}
