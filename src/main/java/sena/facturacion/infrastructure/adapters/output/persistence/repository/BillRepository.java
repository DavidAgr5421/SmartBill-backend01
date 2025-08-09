package sena.facturacion.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.BillEntity;

import java.time.LocalDateTime;


public interface BillRepository extends JpaRepository<BillEntity, Long> {
    @Query("""
    SELECT bd
    FROM BillDetailEntity bd
    JOIN bd.billId b
    JOIN bd.productId p
    WHERE (:userId IS NULL OR b.userId.id = :userId)
      AND (:clientId IS NULL OR b.clientId.id = :clientId)
      AND (:date IS NULL OR FUNCTION('DATE', b.creationDate) = :date)
      AND (:productId IS NULL OR p.id = :productId)
      AND (:payment IS NULL OR b.paymentMethod = :payment)
""")
    Page<BillEntity> filter(
            Pageable pageable,
            @Param("userId") Long userId,
            @Param("clientId") Long clientId,
            @Param("date") LocalDateTime date,
            @Param("productId") Long productId,
            @Param("payment") String payment
    );
}
