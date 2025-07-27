package sena.facturacion.application.ports.input;

import sena.facturacion.domain.model.BillDetail;

import java.math.BigInteger;
import java.util.List;

public interface BillDetailServicePort {

    BillDetail findById(Long id);
    List<BillDetail> findAll();
    List<BillDetail> findByBillId(Long id);
    List<BillDetail> findByProductId(Long id);
    List<BillDetail> findByAmount(BigInteger amount);
    List<BillDetail>
}
