package sena.facturacion.infrastructure.adapters.input.rest.model.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRolResponse {

    private Long id;
    private String rolName;
}
