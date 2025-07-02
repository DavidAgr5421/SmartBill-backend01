package sena.facturacion.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import sena.facturacion.domain.model.UserRol;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    @NotEmpty(message = "Field name cannot be empty or null!")
    private String name;
    @NotEmpty(message = "Field email cannot be empty or null!")
    private String email;
    @NotBlank(message = "Field password cannot be empty or null!")
    private String password;
    @NotBlank(message = "Field userRol cannot be blank!")
    private UserRol rolId;
}
