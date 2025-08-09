package sena.facturacion.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.BillDetailEntity;

import java.math.BigInteger;
import java.util.List;

public interface BillDetailRepository extends JpaRepository<BillDetailEntity, Long> {
    Page<BillDetailEntity> findAll(Pageable pageable);

    Page<BillDetailEntity> findByBillId(Pageable pageable, Long id);

    @Query("SELECT bd FROM BillDetailEntity bd WHERE " +
            "(:id IS NULL OR bd.id = :id) AND " +
            "(:productId IS NULL OR bd.productId.id = :productId) AND " +
            "(:amount IS NULL OR bd.amount = :amount) AND " +
            "(:unitPrice IS NULL OR bd.unitPrice = :unitPrice) AND " +
            "(:subTotal IS NULL OR bd.subTotal = :subTotal)")
    Page<BillDetailEntity> filter(Pageable pageable,
                                  @Param("id") Long id,
                                  @Param("productId") Long productId,
                                  @Param("amount") BigInteger amount,
                                  @Param("unitPrice") Long unitPrice,
                                  @Param("subTotal") Long subTotal);
}
