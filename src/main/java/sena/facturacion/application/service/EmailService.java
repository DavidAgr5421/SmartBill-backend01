package sena.facturacion.application.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import ognl.Token;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import sena.facturacion.application.ports.input.EmailServicePort;
import sena.facturacion.application.ports.output.UserPersistencePort;
import sena.facturacion.domain.model.User;

@Service
@RequiredArgsConstructor
public class EmailService implements EmailServicePort {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;
    private final TokenService tokenService;

    @Value("${spring.mail.username}")
    private String email;

    public void sendRecoveryEmail(User user) {
        String token = tokenService.generateResetToken(user);
        System.out.println("El token generado: "+token);

        MimeMessage message = mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            Context context = new Context();
            context.setVariable("name",user.getName());
            context.setVariable("email",user.getEmail());
            context.setVariable("token",token);

            helper.setFrom(email);
            helper.setTo(email);
            helper.setSubject("Recuperación de contraseña - SmartBill");
            helper.setText(templateEngine.process("recoveryEmailTemplate",context),true);
            mailSender.send(message);
        }catch (MessagingException e){
            throw new RuntimeException("An error has occurred while sending the email.",e);
        }
    }

    @Override
    public void sendToken(String recoveryEmail) {

    }

    @Override
    public void resetPassword(String oldPass, String newPass, String newPassMatch) {

    }
}
