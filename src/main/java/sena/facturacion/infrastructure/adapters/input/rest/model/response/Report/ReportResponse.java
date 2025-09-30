package sena.facturacion.infrastructure.adapters.input.rest.model.response.Report;

import lombok.*;
import sena.facturacion.domain.model.User;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ReportResponse {

    private Long id;
    private User userId;
    private BigDecimal totalSales;
    private BigDecimal monthSales;
    private String observation;
    private BigInteger onLowStockValue;
    private List<String> productOnStock;
    private List<String> productOnLowStock;
    private LocalDateTime createdAt;
}
