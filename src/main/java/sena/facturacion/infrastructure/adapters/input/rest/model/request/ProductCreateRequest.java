package sena.facturacion.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigInteger;

@Builder @Getter
@Setter @NoArgsConstructor @AllArgsConstructor
public class ProductCreateRequest {

    @NotBlank(message = "The name cannot be blank.")
    private String name;
    private String referenceNo;
    private Long unitPrice;
    private BigInteger amount;
}
