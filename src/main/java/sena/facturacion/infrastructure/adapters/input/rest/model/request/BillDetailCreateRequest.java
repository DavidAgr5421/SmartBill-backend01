package sena.facturacion.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigInteger;

@Builder @Getter
@Setter @NoArgsConstructor @AllArgsConstructor
public class BillDetailCreateRequest {

    @NotNull(message = "The Bill ID cannot be null.")
    private Long billId;

    @NotNull(message = "The Product ID cannot be null.")
    private Long productId;

    @NotNull(message = "The Amount cannot be null.")
    private BigInteger amount;

    @NotNull(message = "The Unit Price cannot be null.")
    private Long unitPrice;

    @NotNull(message = "The Unit Measurement cannot be null.")
    private Long unitMeasurement;

    @NotNull(message = "The Subtotal cannot be null.")
    private Long subTotal;

    private String observation;
}
