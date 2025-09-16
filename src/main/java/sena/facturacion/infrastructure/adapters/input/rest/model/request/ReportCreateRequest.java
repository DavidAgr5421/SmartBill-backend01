package sena.facturacion.infrastructure.adapters.input.rest.model.request;

import lombok.*;

import java.math.BigInteger;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ReportCreateRequest {

    private Long userId;
    private String observation;
    private BigInteger onLowStockValue;
}
