package sena.facturacion.infrastructure.adapters.input.rest.model.request.User;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Builder @Getter @Setter
public class UserPutRequest {

    private String name;
    private String email;
    private String password;
    private Long rolId;
    private Boolean active;
}
