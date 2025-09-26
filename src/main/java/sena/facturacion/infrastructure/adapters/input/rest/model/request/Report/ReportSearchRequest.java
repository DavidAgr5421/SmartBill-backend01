package sena.facturacion.infrastructure.adapters.input.rest.model.request.Report;

import lombok.*;

import java.math.BigDecimal;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ReportSearchRequest {

    private Long userId;
    private BigDecimal totalSales;
    private BigDecimal monthSales;
    private String productsOnStock;
    private String productOnLowStock;
}
