package sena.facturacion.application.ports.output;

import sena.facturacion.domain.model.UserRol;

import java.util.List;
import java.util.Optional;

public interface UserRolPersistencePort {

    Optional<UserRol> findByRolId(Long id);
    List<UserRol> findAll();
    Optional<UserRol> findByRolName(String rolName);
    UserRol save(UserRol userRol);
    void deleteByRolId(Long id);
}
