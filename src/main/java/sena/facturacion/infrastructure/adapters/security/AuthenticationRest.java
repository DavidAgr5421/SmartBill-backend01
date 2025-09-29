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
        Authentication authToken = new UsernamePasswordAuthenticationToken(userLoginAuthentication.getEmail(),userLoginAuthentication.getPassword());
        var authenticatedUser = authenticationManager.authenticate(authToken);
        var user = (User) authenticatedUser.getPrincipal();
        var jwtToken = tokenService.generateToken(user);
        System.out.println("Token creado: "+jwtToken);
        AuthToken response = AuthToken.builder()
                .JWTtoken(jwtToken)
                .type("Bearer")
                .id(user.getId())
                .name(user.getName())
                .rolName(user.getRolId().getRolName())
                .build();

        return ResponseEntity.ok(response);
    }

}
