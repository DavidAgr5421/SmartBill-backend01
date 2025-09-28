package sena.facturacion.infrastructure.adapters.input.rest.model.request.Email;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
public class RecoveryPasswordRequest {

    @NotBlank(message = "The email cannot be blank.")
    @Email
    private String email;
}
