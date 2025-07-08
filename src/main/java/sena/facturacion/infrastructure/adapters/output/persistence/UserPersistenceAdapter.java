package sena.facturacion.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sena.facturacion.application.ports.output.UserPersistencePort;
import sena.facturacion.domain.model.User;
import sena.facturacion.infrastructure.adapters.output.persistence.mapper.UserPersistenceMapper;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository repository;

    private final UserPersistenceMapper mapper;

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toUser);
    }

    @Override
    public List<User> findByRolId(Long id) {
        return mapper.toUserList(repository.findByRolId_RolId(id));
    }

    @Override
    public List<User> findAll() {
        return mapper.toUserList(repository.findAll());
    }

    @Override
    public User save(User user) {
        return mapper.toUser(
                repository.save(mapper.toUserEntity(user)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
