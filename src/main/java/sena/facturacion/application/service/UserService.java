package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.facturacion.application.ports.input.UserServicePort;
import sena.facturacion.application.ports.output.UserPersistencePort;
import sena.facturacion.domain.model.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserServicePort {

    private final UserPersistencePort persistencePort;

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(Long id, User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
