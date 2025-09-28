package sena.facturacion.infrastructure.adapters.input.rest.model.request.User;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class UserLoginAuthentication {

    @NotBlank(message = "Fill the email.")
    private String email;
    @NotBlank(message = "Fill the password.")
    private String password;
}
