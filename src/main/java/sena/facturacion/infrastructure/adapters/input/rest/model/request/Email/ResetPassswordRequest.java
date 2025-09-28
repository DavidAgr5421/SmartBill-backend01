package sena.facturacion.infrastructure.adapters.input.rest.model.request.Email;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter @AllArgsConstructor @NoArgsConstructor
public class ResetPassswordRequest {

    @NotBlank(message = "The new password cannot be blank!.")
    @Size(min = 6, message = "Password must be at least 6 characters.")
    private String newPassword;

}
