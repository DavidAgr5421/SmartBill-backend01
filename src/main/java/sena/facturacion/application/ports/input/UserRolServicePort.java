package sena.facturacion.application.ports.input;

import sena.facturacion.domain.model.UserRol;

import java.util.List;

public interface UserRolServicePort {

    UserRol getRolNameById(Long id);
    List<UserRol> getAllRols();

    UserRol save(UserRol userRol);
    UserRol update(UserRol userRol);

    UserRol delete(UserRol userRol);
}
