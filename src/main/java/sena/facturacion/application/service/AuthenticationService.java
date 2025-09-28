package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sena.facturacion.application.ports.output.UserPersistencePort;
import sena.facturacion.domain.exception.User.UserNotFoundException;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UserPersistencePort persistencePort;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return persistencePort.findByLogin(email).orElseThrow(UserNotFoundException::new);
    }
}
