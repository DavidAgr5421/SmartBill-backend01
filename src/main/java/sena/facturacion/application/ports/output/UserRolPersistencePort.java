package sena.facturacion.application.ports.output;

import sena.facturacion.domain.model.UserRol;

import java.util.List;
import java.util.Optional;

public interface UserRolPersistencePort {

    Optional<UserRol> findById(Long id);
    List<UserRol> findAll();
    UserRol save(UserRol userRol);
    void deleteById(Long id);
}
