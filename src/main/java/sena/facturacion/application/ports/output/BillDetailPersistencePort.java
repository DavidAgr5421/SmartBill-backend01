package sena.facturacion.application.ports.output;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import sena.facturacion.domain.model.BillDetail;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface BillDetailPersistencePort {

    Optional<BillDetail> findById(Long id);
    Page<BillDetail> findAll(Pageable pageable);
    Page<BillDetail> findByBillId(Pageable pageable,Long id);
    Page<BillDetail> filter(Pageable pageable, Long id,Long productId, BigInteger amount, Long unitPrice, Long subTotal);

    BillDetail save(BillDetail billDetail);
    void deleteById(Long id);
}
