package sena.facturacion.application.ports.input;

import sena.facturacion.domain.model.UserRol;

import java.util.List;

public interface UserRolServicePort {

    UserRol findById(Long id);
    List<UserRol> findAll();

    UserRol save(UserRol userRol);
    UserRol update(Long id, UserRol userRol);

    void delete(Long id);
}
