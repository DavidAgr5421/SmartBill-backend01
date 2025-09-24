package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sena.facturacion.application.ports.input.BillDetailServicePort;
import sena.facturacion.application.ports.output.BillDetailPersistencePort;
import sena.facturacion.application.ports.output.BillPersistencePort;
import sena.facturacion.application.ports.output.ProductPersistencePort;
import sena.facturacion.domain.exception.BillNotFoundException;
import sena.facturacion.domain.exception.ProductNotFoundException;
import sena.facturacion.domain.model.BillDetail;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillDetailSearchRequest;
import sena.facturacion.utils.PatchUtils;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillDetailService implements BillDetailServicePort {

    private final BillDetailPersistencePort persistencePort;
    private final BillPersistencePort billPersistencePort;
    private final ProductPersistencePort productPersistencePort;

    @Override
    public BillDetail findById(Long id) {
        return persistencePort.findById(id).orElseThrow(BillNotFoundException::new);
    }

    @Override
    public Page<BillDetail> findAll(Pageable pageable) {
        return persistencePort.findAll(pageable);
    }

    @Override
    public List<BillDetail> search(BillDetailSearchRequest request) {
        return persistencePort.search(request);
    }

    @Override
    public BillDetail save(BillDetail detail) {
        var bill = billPersistencePort.findById(detail.getBillId().getId()).orElseThrow(BillNotFoundException::new);
        var product = productPersistencePort.findById(detail.getProductId().getId()).orElseThrow(ProductNotFoundException::new);
        detail.setBillId(bill);
        detail.setProductId(product);
        return persistencePort.save(detail);
    }

    @Override
    public BillDetail update(Long id, BillDetail detail) {
        return persistencePort.findById(id).map(foundBillDetail -> {
            PatchUtils.copyNonNullProperties(detail,foundBillDetail);
            return persistencePort.save(foundBillDetail);
        }).orElseThrow(BillNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        persistencePort.deleteById(id);
    }

}
