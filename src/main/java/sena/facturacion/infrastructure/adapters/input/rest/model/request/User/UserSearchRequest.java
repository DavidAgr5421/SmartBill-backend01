package sena.facturacion.infrastructure.adapters.input.rest.model.request.User;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class UserSearchRequest {

    private String name;
    private String email;
    private Long rolId;
    private Boolean active;
}
