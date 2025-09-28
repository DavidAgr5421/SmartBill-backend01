package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {


    @Autowired
    JavaMailSender mailSender;

    @Value("{spring.mail.username}")
    private String email;

    public void sendEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email);
        message.setTo(email);
        message.setSubject("Hola");
        message.setText("HOLA");

        mailSender.send(message);

    }
}
