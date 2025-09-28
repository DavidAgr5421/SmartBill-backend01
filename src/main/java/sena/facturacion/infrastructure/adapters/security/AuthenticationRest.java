package sena.facturacion.infrastructure.adapters.security;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sena.facturacion.application.service.TokenService;
import sena.facturacion.domain.model.AuthToken;
import sena.facturacion.domain.model.User;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.UserLoginAuthentication;

@RestController
@RequestMapping("/login")
public class AuthenticationRest {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity userAuthentication(@RequestBody @Valid UserLoginAuthentication userLoginAuthentication){
        System.out.println("Se ingresa al rest y se valida el authentication");
        Authentication authToken = new UsernamePasswordAuthenticationToken(userLoginAuthentication.getEmail(),userLoginAuthentication.getPassword());
        System.out.println("Ahora se crea el token y la auth con el manager");
        var authenticatedUser = authenticationManager.authenticate(authToken);
        System.out.println("AuthUser creado: "+authenticatedUser);
        var jwtToken = tokenService.generateToken((User) authenticatedUser.getPrincipal());
        System.out.println("Token creado: "+jwtToken);
        return ResponseEntity.ok(new AuthToken(jwtToken,"Bearer"));
    }

}
