package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.facturacion.application.ports.input.BillServicePort;
import sena.facturacion.domain.model.Bill;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService implements BillServicePort {
    @Override
    public Bill findById(Long id) {
        return null;
    }

    @Override
    public List<Bill> findByUserId(Long id) {
        return List.of();
    }

    @Override
    public List<Bill> findByClientId(Long id) {
        return List.of();
    }

    @Override
    public List<Bill> findAll() {
        return List.of();
    }

    @Override
    public List<Bill> findByCreationDate(LocalDateTime dateTime) {
        return List.of();
    }

    @Override
    public List<Bill> findByProduct(Long productId) {
        return List.of();
    }

    @Override
    public List<Bill> findByPaymentMethod(String payment) {
        return List.of();
    }

    @Override
    public Bill save(Bill bill) {
        return null;
    }

    @Override
    public Bill update(Long id, Bill bill) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
