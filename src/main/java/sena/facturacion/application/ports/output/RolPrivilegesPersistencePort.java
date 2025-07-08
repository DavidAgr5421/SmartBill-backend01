package sena.facturacion.application.ports.output;

import sena.facturacion.domain.model.RolPrivileges;

import java.util.Optional;

public interface RolPrivilegesPersistencePort {

    Optional<RolPrivileges> findById(Long id);
    RolPrivileges save(RolPrivileges rolPrivileges);

    void delete(Long id);
}
