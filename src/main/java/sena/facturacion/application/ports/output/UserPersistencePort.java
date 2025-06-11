package sena.facturacion.application.ports.output;

import sena.facturacion.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserPersistencePort {

    Optional<User> findById(Long id);
    List<User> findAll();
    User save(User user);
    void deleteById(Long id);
}
