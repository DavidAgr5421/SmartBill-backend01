package sena.facturacion.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sena.facturacion.application.ports.output.BillDetailPersistencePort;
import sena.facturacion.domain.model.BillDetail;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Bill.BillDetailSearchRequest;
import sena.facturacion.infrastructure.adapters.output.persistence.mapper.BillDetailPersistenceMapper;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.BillDetailRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.specification.BillDetailSpecification;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BillDetailPersistenceAdapter implements BillDetailPersistencePort {

    private final BillDetailRepository repository;
    private final BillDetailPersistenceMapper mapper;

    @Override
    public Optional<BillDetail> findById(Long id) {
        return repository.findById(id).map(mapper::toDetail);
    }

    @Override
    public Page<BillDetail> findAll(Pageable pageable) {
        return mapper.toDomainPage(repository.findAll(pageable));
    }

    @Override
    public List<BillDetail> search(BillDetailSearchRequest request) {
        return mapper.toDomainList(repository.findAll(BillDetailSpecification.withFilters(request)));
    }

    @Override
    public BillDetail save(BillDetail billDetail) {
        return mapper.toDetail(repository.save(mapper.toDetailEntity(billDetail)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
