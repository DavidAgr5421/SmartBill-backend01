package sena.facturacion.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.BillDetailEntity;

import java.math.BigInteger;
import java.util.List;

public interface BillDetailRepository extends JpaRepository<BillDetailEntity, Long> {
    List<BillDetailEntity> findByBillId(Long id);
    List<BillDetailEntity> findByProductId(Long id);
    List<BillDetailEntity> findByAmount(BigInteger amount);
    List<BillDetailEntity> findByUnitPrice(Long price);
    List<BillDetailEntity> findBySubTotal(Long subtotal);
}
