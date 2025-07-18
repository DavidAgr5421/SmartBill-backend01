package sena.facturacion.application.ports.input;

import sena.facturacion.domain.model.Bill;

import java.time.LocalDateTime;
import java.util.List;

public interface BillServicePort {

    Bill findById(Long id);
    List<Bill> findByUserId(Long id);
    List<Bill> findByClientId(Long id);
    List<Bill> findAll();
    List<Bill> findByCreationDate(LocalDateTime date);
    List<Bill> findByProduct(Long productId);
    List<Bill> findByPaymentMethod(String payment);

    Bill save(Bill bill);
    Bill update(Long id, Bill bill);

    void deleteById(Long id);
}