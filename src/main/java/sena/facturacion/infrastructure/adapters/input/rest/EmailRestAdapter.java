package sena.facturacion.infrastructure.adapters.input.rest;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sena.facturacion.application.ports.output.UserPersistencePort;
import sena.facturacion.application.service.EmailService;
import sena.facturacion.application.service.TokenService;
import sena.facturacion.domain.model.User;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Email.RecoveryPasswordRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Email.ResetPassswordRequest;

@RestController
@RequestMapping("/recovery")
@RequiredArgsConstructor
public class EmailRestAdapter {

    private final EmailService emailService;
    private final UserPersistencePort persistencePort;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<String> sendEmailTemplate(@RequestBody @Valid RecoveryPasswordRequest request){
        return persistencePort.findByLogin(request.getEmail()).map(user -> {
            emailService.sendRecoveryEmail((User) user);
            return ResponseEntity.ok("The email has been sent successfully.");
        }).orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).body("The email is not registered."));
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestBody @Valid ResetPassswordRequest request, @RequestParam("token") String token){
        System.out.println("TOKEN REST RECEIVED: "+token);
        String email = tokenService.validateResetToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid or expired token"));
        return persistencePort.findByLogin(email).map(user -> {
            user.setPassword(passwordEncoder.encode(request.getNewPassword()));
            persistencePort.save(user);
            return ResponseEntity.ok("Password succesfully updated.");
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found for token"));
    }
}
