package sena.facturacion.application.ports.output;

public interface EmailPersistencePort {
    void sendToken(String recoveryEmail);
    void resetPassword(String oldPass, String newPass, String newPassMatch);
}
