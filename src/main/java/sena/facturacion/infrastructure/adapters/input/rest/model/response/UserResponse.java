package sena.facturacion.infrastructure.adapters.input.rest.model.response;

import lombok.*;
import sena.facturacion.domain.model.UserRol;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime creationDate;
    private UserRol rolId;
}
