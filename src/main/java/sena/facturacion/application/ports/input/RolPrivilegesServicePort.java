package sena.facturacion.application.ports.input;

import sena.facturacion.domain.model.RolPrivileges;

public interface RolPrivilegesServicePort {

    RolPrivileges findById(Long id);

    RolPrivileges save(RolPrivileges rolPrivileges);
    RolPrivileges update(Long id, RolPrivileges rolPrivileges);

    void delete(Long id);
}
