package sena.facturacion.infrastructure.adapters.input.rest.model.response.User;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRolResponse {

    private Long rolId;
    private String rolName;
}
