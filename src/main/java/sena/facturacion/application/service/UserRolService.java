package sena.facturacion.application.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.facturacion.application.ports.input.UserRolServicePort;

import sena.facturacion.application.ports.output.RolPrivilegesPersistencePort;
import sena.facturacion.application.ports.output.UserPersistencePort;
import sena.facturacion.application.ports.output.UserRolPersistencePort;
import sena.facturacion.domain.exception.UserRolNotFoundException;
import sena.facturacion.domain.model.RolPrivileges;
import sena.facturacion.domain.model.User;
import sena.facturacion.domain.model.UserRol;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRolService implements UserRolServicePort {

    private final UserRolPersistencePort persistencePort;
    private final UserPersistencePort userPersistencePort;
    private final RolPrivilegesPersistencePort privilegesPersistencePort;

    @Override
    public UserRol findByRolId(Long id) {
        return persistencePort.findByRolId(id).orElseThrow(UserRolNotFoundException::new);
    }

    @Override
    public List<UserRol> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public UserRol findByRolName(String name) {
        return persistencePort.findByRolName(name).orElseThrow(UserRolNotFoundException::new);
    }

    @Override
    public UserRol save(UserRol userRol) {
        UserRol rol = persistencePort.save(userRol);
        privilegesPersistencePort.save(new RolPrivileges(rol));
        return rol;
    }

    @Override
    public UserRol update(Long id, UserRol rol) {
        return persistencePort.findByRolId(id).map(UserRolDB -> {
                    UserRolDB.setRolName(rol.getRolName());
                    return persistencePort.save(UserRolDB);
                }).orElseThrow(UserRolNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        persistencePort.findByRolId(id).orElseThrow(UserRolNotFoundException::new);
        List<User> assignedUsers = userPersistencePort.findByRolId(id);
        Optional<RolPrivileges> privileges = privilegesPersistencePort.findById(id);
        if(!assignedUsers.isEmpty()){
            var defaultRol = persistencePort.findByRolId(1L).orElseThrow(UserRolNotFoundException::new);
                for(User user : assignedUsers){
                    user.setRolId(defaultRol);
                    userPersistencePort.save(user);
                }
            }
        if(privileges.isPresent()){
            privilegesPersistencePort.delete(id);
        }
        persistencePort.deleteByRolId(id);
        }
}
