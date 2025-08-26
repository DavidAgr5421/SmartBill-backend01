package sena.facturacion.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigInteger;

@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class BillDetailPutRequest {

    @NotNull(message = "The Bill Detail ID cannot be null.")
    private Long id;

    private Long billId;

    private Long productId;

    private BigInteger amount;

    private Long subTotal;

    private String observation;
}
