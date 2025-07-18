package sena.facturacion.application.ports.output;

import sena.facturacion.domain.model.Bill;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BillPersistencePort {

    Optional<Bill> findById(Long id);
    List<Bill> findByUserId(Long id);
    List<Bill> findByClientId(Long id);
    List<Bill> findAll();
    List<Bill> findByCreationDate(LocalDateTime date);
    List<Bill> findByProduct(Long id);
    List<Bill> findByPaymentMethod(String payment);

    Bill save(Bill bill);
    void deleteById(Long id);
}
