package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
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
    public List<BillDetail> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public List<BillDetail> findByBillId(Long id) {
        return persistencePort.findByBillId(id);
    }

    @Override
    public List<BillDetail> findByProductId(Long id) {
        return persistencePort.findByProductId(id);
    }

    @Override
    public List<BillDetail> findByAmount(BigInteger amount) {
        return persistencePort.findByAmount(amount);
    }

    @Override
    public List<BillDetail> findByUnitPrice(Long unitPrice) {
        return persistencePort.findByUnitPrice(unitPrice);
    }

    @Override
    public List<BillDetail> findBySubTotal(Long subTotal) {
        return persistencePort.findBySubTotal(subTotal);
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
            foundBillDetail.setUnitPrice(detail.getUnitPrice());
            foundBillDetail.setUnitMeasurement(detail.getUnitMeasurement());
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
