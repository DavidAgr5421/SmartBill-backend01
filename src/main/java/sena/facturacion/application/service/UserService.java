package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.facturacion.application.ports.input.UserServicePort;
import sena.facturacion.application.ports.output.UserPersistencePort;
import sena.facturacion.application.ports.output.UserRolPersistencePort;
import sena.facturacion.domain.exception.UserNotFoundException;
import sena.facturacion.domain.model.User;
import sena.facturacion.domain.model.UserRol;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserServicePort {

    private final UserPersistencePort persistencePort;
    private final UserRolPersistencePort rolPersistencePort;

    @Override
    public User findById(Long id) {
        return persistencePort.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> findByRolId(Long id) {
        return persistencePort.findByRolId(id);
    }

    @Override
    public List<User> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public User save(User user) {
        Optional<UserRol> rol = rolPersistencePort.findByRolId(user.getRolId().getRolId());
        rol.ifPresent(user::setRolId);
        return persistencePort.save(user);
    }

    @Override
    public User update(Long id, User user) {
        return persistencePort.findById(id).map(userDb -> {
            userDb.setName(user.getName());
            userDb.setEmail(user.getEmail());
            userDb.setPassword(user.getPassword());
            userDb.setRolId(user.getRolId());
            return persistencePort.save(userDb);
        }).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        persistencePort.deleteById(id);
    }
}
