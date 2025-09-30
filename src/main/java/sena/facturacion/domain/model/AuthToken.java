package sena.facturacion.domain.model;

import lombok.*;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class AuthToken {

    private String JWTtoken;

    private String type;

    private Long id;
    private String name;
    private String rolName;
    private Long rolId;
}
