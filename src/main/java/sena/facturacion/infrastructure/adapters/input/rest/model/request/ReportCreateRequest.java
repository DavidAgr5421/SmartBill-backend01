package sena.facturacion.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigInteger;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ReportCreateRequest {

    @NotNull(message = "The User Id cannot be null")
    private Long userId;
    private String observation;
    @NotNull(message = "The value for the Low Stock threshold cannot be null")
    private BigInteger onLowStockValue;
}
