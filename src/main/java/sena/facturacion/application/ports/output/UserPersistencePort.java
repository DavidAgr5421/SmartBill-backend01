package sena.facturacion.application.ports.output;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.User;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.UserSearchRequest;

import java.util.List;
import java.util.Optional;

public interface UserPersistencePort {

    Optional<User> findById(Long id);
    List<User> findByRolId(Long id);
    List<User> findAll();
    Page<User> search(Pageable pageable, UserSearchRequest request);
    User save(User user);
    boolean existsByUserId(Long id);

    void deleteById(Long id);
}
