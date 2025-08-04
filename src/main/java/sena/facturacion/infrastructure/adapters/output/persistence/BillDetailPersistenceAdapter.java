package sena.facturacion.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import sena.facturacion.application.ports.output.BillDetailPersistencePort;
import sena.facturacion.domain.model.BillDetail;
import sena.facturacion.infrastructure.adapters.output.persistence.mapper.BillDetailPersistenceMapper;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.BillDetailRepository;

import java.math.BigInteger;
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
    public List<BillDetail> findAll() {
        return mapper.toDetailList(repository.findAll());
    }

    @Override
    public List<BillDetail> findByBillId(Long id) {
        return mapper.toDetailList(repository.findByBillId(id));
    }

    @Override
    public List<BillDetail> findByProductId(Long id) {
        return mapper.toDetailList(repository.findByProductId(id));
    }

    @Override
    public List<BillDetail> findByAmount(BigInteger amount) {
        return mapper.toDetailList(repository.findByAmount(amount));
    }

    @Override
    public List<BillDetail> findByUnitPrice(Long unitPrice) {
        return mapper.toDetailList(repository.findByUnitPrice(unitPrice));
    }

    @Override
    public List<BillDetail> findBySubTotal(Long subTotal) {
        return mapper.toDetailList(repository.findBySubTotal(subTotal));
    }

    @Override
    public BillDetail save(BillDetail billDetail) {
        return mapper.toDetail(repository.save(mapper.toDetaiLEntity(billDetail)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
