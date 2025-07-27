package sena.facturacion.application.ports.output;

import sena.facturacion.domain.model.BillDetail;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface BillDetailPersistencePort {

    Optional<BillDetail> findById(Long id);
    List<BillDetail> findAll();
    List<BillDetail> findByBillId(Long id);
    List<BillDetail> findByProductId(Long id);
    List<BillDetail> findByAmount(BigInteger amount);
    List<BillDetail> findByUnitPrice(Long unitPrice);
    List<BillDetail> findBySubTotal(Long subTotal);

    BillDetail save(BillDetail billDetail);
    void deleteById(Long id);
}
