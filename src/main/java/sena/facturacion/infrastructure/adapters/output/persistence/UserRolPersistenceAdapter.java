package sena.facturacion.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sena.facturacion.application.ports.output.UserRolPersistencePort;
import sena.facturacion.domain.model.UserRol;
import sena.facturacion.infrastructure.adapters.output.persistence.mapper.UserRolPersistenceMapper;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.UserRolRepository;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRolPersistenceAdapter implements UserRolPersistencePort {

    private final UserRolRepository repository;
    private final UserRolPersistenceMapper mapper;

    @Override
    public Optional<UserRol> findByRolId(Long id) {
        return repository.findById(id).map(mapper::toUserRol);
    }

    @Override
    public List<UserRol> findAll() {
        return mapper.toUserRolList(repository.findAll());
    }

    @Override
    public Optional<UserRol> findByRolName(String rolName) {
        return repository.findByRolName(rolName).map(mapper::toUserRol);
    }

    @Override
    public UserRol save(UserRol userRol) {
        return mapper.toUserRol(repository.save(mapper.toUserRolEntity(userRol)));
    }

    @Override
    public void deleteByRolId(Long id) {
        repository.deleteById(id);
    }
}
