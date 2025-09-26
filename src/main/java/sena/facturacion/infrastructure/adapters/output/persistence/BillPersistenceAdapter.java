package sena.facturacion.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sena.facturacion.application.ports.output.BillPersistencePort;
import sena.facturacion.domain.model.Bill;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Bill.BillSearchRequest;
import sena.facturacion.infrastructure.adapters.output.persistence.mapper.BillPersistenceMapper;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.BillRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.specification.BillSpecification;

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
    public Page<Bill> findAll(Pageable pageable) {
        return mapper.toDomainPage(repository.findAll(pageable));
    }

    @Override
    public Page<Bill> search(Pageable pageable, BillSearchRequest request) {
        return mapper.toDomainPage(repository.findAll(BillSpecification.withFilters(request), pageable));
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
