package sena.facturacion.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import sena.facturacion.application.ports.output.UserPersistencePort;
import sena.facturacion.domain.model.User;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.UserSearchRequest;
import sena.facturacion.infrastructure.adapters.output.persistence.mapper.UserPersistenceMapper;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.UserRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.specification.UserSpecification;

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
    public Optional<User> findByLogin(String email) {
        return repository.findByEmail(email).map(mapper::toUser);
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
    public Page<User> search(Pageable pageable, UserSearchRequest request) {
        return mapper.toDomainPage(repository.findAll(UserSpecification.withFilters(request),pageable));
    }

    @Override
    public User save(User user) {
        return mapper.toUser(
                repository.save(mapper.toUserEntity(user)));
    }

    @Override
    public boolean existsByUserId(Long id) {
        return repository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
