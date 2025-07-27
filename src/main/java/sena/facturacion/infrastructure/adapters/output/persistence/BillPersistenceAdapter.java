package sena.facturacion.infrastructure.adapters.output.persistence;

import sena.facturacion.application.ports.output.BillPersistencePort;
import sena.facturacion.domain.model.Bill;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class BillPersistenceAdapter implements BillPersistencePort {
    @Override
    public Optional<Bill> findById(Long id) {
        return Optional.empty();
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
    public List<Bill> findByCreationDate(LocalDateTime date) {
        return List.of();
    }

    @Override
    public List<Bill> findByProduct(Long id) {
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
    public void deleteById(Long id) {

    }
}
