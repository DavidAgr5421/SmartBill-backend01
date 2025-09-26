package sena.facturacion.application.ports.input;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.User;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.UserSearchRequest;

import java.util.List;

public interface UserServicePort {

    User findById(Long id);
    List<User> findByRolId(Long id);
    List<User> findAll();
    Page<User> search(Pageable pageable, UserSearchRequest request);

    User save(User user);
    User update(Long id, User user);

    void deleteById(Long id);
}
