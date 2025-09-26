package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.facturacion.application.mapper.PrivilegesServiceMapper;
import sena.facturacion.application.ports.input.RolPrivilegesServicePort;
import sena.facturacion.application.ports.output.RolPrivilegesPersistencePort;
import sena.facturacion.domain.exception.User.RolPrivilegesNotFound;
import sena.facturacion.domain.model.RolPrivileges;

@Service
@RequiredArgsConstructor
public class RolPrivilegesService implements RolPrivilegesServicePort {

    private final RolPrivilegesPersistencePort persistencePort;
    private final PrivilegesServiceMapper mapper;

    @Override
    public RolPrivileges findById(Long id) {
        return persistencePort.findById(id).orElseThrow(RolPrivilegesNotFound::new);
    }

    @Override
    public RolPrivileges save(RolPrivileges rolPrivileges) {
        return persistencePort.save(rolPrivileges);
    }

    @Override
    public RolPrivileges update(Long id, RolPrivileges rolPrivileges) {
        return persistencePort.findById(id).map(privileges -> {
                mapper.updatePrivilegesFromDto(rolPrivileges,privileges);
            return persistencePort.save(privileges);
        }).orElseThrow(RolPrivilegesNotFound::new);
    }

    @Override
    public void delete(Long id) {
        persistencePort.delete(id);
    }
}
