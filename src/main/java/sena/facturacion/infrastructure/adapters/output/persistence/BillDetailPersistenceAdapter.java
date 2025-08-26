package sena.facturacion.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sena.facturacion.application.ports.output.BillDetailPersistencePort;
import sena.facturacion.domain.model.BillDetail;
import sena.facturacion.infrastructure.adapters.output.persistence.mapper.BillDetailPersistenceMapper;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.BillDetailRepository;

import java.math.BigInteger;
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
    public Page<BillDetail> findByBillId(Pageable pageable, Long id) {
        return mapper.toDomainPage(repository.findByBillId(pageable,id));
    }

    @Override
    public Page<BillDetail> filter(Pageable pageable, Long id, Long productId, BigInteger amount, Long subTotal) {
        return mapper.toDomainPage(repository.filter(pageable,id,productId,amount,subTotal));
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
