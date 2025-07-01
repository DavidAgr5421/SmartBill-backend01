package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.facturacion.application.ports.input.UserRolServicePort;

import sena.facturacion.application.ports.output.UserRolPersistencePort;
import sena.facturacion.domain.exception.UserNotFoundException;
import sena.facturacion.domain.model.UserRol;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRolService implements UserRolServicePort {

    private final UserRolPersistencePort persistencePort;


    @Override
    public UserRol findById(Long id) {
        return persistencePort.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<UserRol> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public UserRol save(UserRol userRol) {
        return persistencePort.save(userRol);
    }

    @Override
    public UserRol update(Long id, UserRol rol) {
        return persistencePort.findById(id).map(UserRolDB -> {
                    UserRolDB.setRolName(rol.getRolName());
                    return persistencePort.save(UserRolDB);
                }).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        persistencePort.deleteById(id);
    }
}
