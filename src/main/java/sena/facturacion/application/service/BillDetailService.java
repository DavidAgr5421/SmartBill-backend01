package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sena.facturacion.application.ports.input.BillDetailServicePort;
import sena.facturacion.application.ports.output.BillDetailPersistencePort;
import sena.facturacion.domain.exception.BillNotFoundException;
import sena.facturacion.domain.model.BillDetail;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillDetailService implements BillDetailServicePort {

    private final BillDetailPersistencePort persistencePort;

    @Override
    public BillDetail findById(Long id) {
        return persistencePort.findById(id).orElseThrow(BillNotFoundException::new);
    }

    @Override
    public Page<BillDetail> findAll(Pageable pageable) {
        return persistencePort.findAll(pageable);
    }

    @Override
    public Page<BillDetail> findByBillId(Pageable pageable,Long id) {
        return persistencePort.findByBillId(pageable,id);
    }

    @Override
    public Page<BillDetail> filter(Pageable pageable,Long id,Long productId, BigInteger amount, Long subTotal) {
        return persistencePort.filter(pageable,id,productId, amount, subTotal);
    }

    @Override
    public BillDetail save(BillDetail detail) {
        return persistencePort.save(detail);
    }

    @Override
    public BillDetail update(Long id, BillDetail detail) {
        return persistencePort.findById(id).map(foundBillDetail -> {
            foundBillDetail.setBillId(detail.getBillId());
            foundBillDetail.setProductId(detail.getProductId());
            foundBillDetail.setAmount(detail.getAmount());
            foundBillDetail.setSubTotal(detail.getSubTotal());
            foundBillDetail.setObservation(detail.getObservation());
            return persistencePort.save(foundBillDetail);
        }).orElseThrow(BillNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        persistencePort.deleteById(id);
    }
}
