package sena.facturacion.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sena.facturacion.application.ports.output.BillPersistencePort;
import sena.facturacion.domain.model.Bill;
import sena.facturacion.infrastructure.adapters.output.persistence.mapper.BillPersistenceMapper;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.BillRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BillPersistenceAdapter implements BillPersistencePort {

    private final BillRepository repository;
    private final BillPersistenceMapper mapper;

    @Override
    public Optional<Bill> findById(Long id) {
        return repository.findById(id).map(mapper::toBill);
    }

    @Override
    public List<Bill> findByUserId(Long id) {
        return mapper.toBillList(repository.findByUserId(id));
    }

    @Override
    public List<Bill> findByClientId(Long id) {
        return mapper.toBillList(repository.findByClientId(id));
    }

    @Override
    public List<Bill> findAll() {
        return mapper.toBillList(repository.findAll());
    }

    @Override
    public List<Bill> findByCreationDate(LocalDateTime date) {
        return mapper.toBillList(repository.findByCreationDate(date));
    }

    @Override
    public List<Bill> findByProduct(Long id) {
        return mapper.toBillList(repository.findByProduct(id));
    }

    @Override
    public List<Bill> findByPaymentMethod(String payment) {
        return mapper.toBillList(repository.findByPaymentMethod(payment));
    }

    @Override
    public Bill save(Bill bill) {
        return mapper.toBill(repository.save(mapper.toBillEntity(bill)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
