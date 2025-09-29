package sena.facturacion.infrastructure.adapters.input.rest.model.request.Client;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder @Getter
@Setter @NoArgsConstructor @AllArgsConstructor
public class ClientRequest {

    @NotBlank(message = "The Name cannot be blank.")
    private String name;
    private String email;
    @NotBlank(message = "The Address cannot be blank.")
    private String address;
    @NotBlank(message = "The Contact cannot be blank.")
    private String contact;
}
