package sena.facturacion.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime creationDate;
    private Integer rolId;
}
