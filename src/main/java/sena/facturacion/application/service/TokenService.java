package sena.facturacion.application.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sena.facturacion.domain.model.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generateToken(User user){
        try {
            System.out.println("Se esta creando el token....");
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            String token = JWT.create()
                    .withIssuer("SmartBill")
                    .withSubject(user.getEmail())
                    .withClaim("id",user.getId())
                    .withClaim("role",user.getRolId().getRolName())
                    .withExpiresAt(generateExpireDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException e){
            throw new RuntimeException();
        }
    }

    private Instant generateExpireDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }

    public String getSubject(String token){
        if(token== null){
            throw new RuntimeException();
        }
        DecodedJWT verifier = null;
        try{
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("SmartBill")
                    .build()
                    .verify(token);

        } catch (JWTVerificationException e){
            System.out.println("Aqui fallo en verificacion del token");
            throw new RuntimeException("Verification failed.");
        }
        if(verifier.getSubject() == null){
            System.out.println("Aqui se mando un verifier invalido");
            throw new RuntimeException("Invalid Verifier");
        }
        return verifier.getSubject();
    }

    public String generateResetToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(apiSecret);
        return JWT.create()
                .withIssuer("SmartBill")
                .withSubject(user.getEmail())
                .withClaim("reset",true)
                .withExpiresAt(LocalDateTime.now().plusMinutes(15).toInstant(ZoneOffset.of("-05:00")))
                .sign(algorithm);
    }

    public Optional<String> validateResetToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            DecodedJWT decodedJWT = JWT.require(algorithm)
                    .withIssuer("SmartBill")
                    .withClaim("reset",true)
                    .build()
                    .verify(token);
            return Optional.of(decodedJWT.getSubject());
        }catch (JWTVerificationException e){
            return Optional.empty();
        }
    }
}
