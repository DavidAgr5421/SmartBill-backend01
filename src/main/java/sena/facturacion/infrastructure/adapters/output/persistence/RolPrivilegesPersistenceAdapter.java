package sena.facturacion.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sena.facturacion.application.ports.output.RolPrivilegesPersistencePort;
import sena.facturacion.domain.model.RolPrivileges;
import sena.facturacion.infrastructure.adapters.output.persistence.mapper.RolPrivilegesPersistenceMapper;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.RolPrivilegesRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RolPrivilegesPersistenceAdapter implements RolPrivilegesPersistencePort {

    private final RolPrivilegesRepository repository;
    private final RolPrivilegesPersistenceMapper mapper;

    @Override
    public Optional<RolPrivileges> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public RolPrivileges save(RolPrivileges rolPrivileges) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
