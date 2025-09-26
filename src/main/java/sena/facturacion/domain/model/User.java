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
    private UserRol rolId;
    private boolean active = true;

    public User(Long id){
        this.id = id;
        this.name = null;
        this.email = null;
        this.password = null;
        this.creationDate = null;
        this.rolId = null;
    }

}
