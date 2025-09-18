package sena.facturacion.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRol {
    private String rolName;
    private Long rolId;

    public UserRol(Long id){
        this.rolId = id;
    }
}
