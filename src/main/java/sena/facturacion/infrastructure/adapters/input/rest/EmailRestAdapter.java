package sena.facturacion.infrastructure.adapters.input.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sena.facturacion.application.service.EmailService;

@RestController
@RequestMapping("/recovery")
@RequiredArgsConstructor
public class EmailRestAdapter {

    private final EmailService emailService;

    @GetMapping
    public ResponseEntity<String> sendEmail(){
        emailService.sendEmail();
        return ResponseEntity.ok("Email send succesfully");
    }
}
