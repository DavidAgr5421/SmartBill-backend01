package sena.facturacion.application.ports.input;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.Bill;

import java.time.LocalDateTime;

public interface BillServicePort {

    Bill findById(Long id);
    Page<Bill> findAll(Pageable pageable);
    Page<Bill> filter(Pageable pageable,Long userId, Long clientId, LocalDateTime date, Long productId, String payment);

    Bill save(Bill bill);
    Bill update(Long id, Bill bill);

    void deleteById(Long id);
}