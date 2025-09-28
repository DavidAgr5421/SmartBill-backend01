package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sena.facturacion.application.mapper.UserServiceMapper;
import sena.facturacion.application.ports.input.UserServicePort;
import sena.facturacion.application.ports.output.UserPersistencePort;
import sena.facturacion.domain.exception.User.UserNotFoundException;
import sena.facturacion.domain.model.User;
import sena.facturacion.domain.model.UserRol;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.UserSearchRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserServicePort {

    private final UserPersistencePort persistencePort;
    private final UserRolService rolService;
    private final UserServiceMapper mapper;
    private final PasswordEncoder passwordEncoder;

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
    public Page<User> search(Pageable pageable, UserSearchRequest request) {
        return persistencePort.search(pageable,request);
    }

    @Override
    public User save(User user) {
        UserRol rol = rolService.findByRolId(user.getRolId().getRolId());
        user.setRolId(rol);
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return persistencePort.save(user);
    }

    @Override
    public User update(Long id, User user) {
        return persistencePort.findById(id).map(userDb -> {
            if(user.getRolId().getRolId() != null){
                var rolRef = rolService.findByRolId(user.getRolId().getRolId());
                userDb.setRolId(rolRef);
            }
            mapper.updateUserFromDto(user,userDb);
            return persistencePort.save(userDb);
        }).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        var user = persistencePort.findById(id).orElseThrow(UserNotFoundException::new);
        if(persistencePort.existsByUserId(id)){
            user.setActive(false);
            persistencePort.save(user);
        }else{
        persistencePort.deleteById(id);}
    }
}
