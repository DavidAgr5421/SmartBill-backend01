package sena.facturacion.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.BillEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface BillRepository extends JpaRepository<BillEntity, Long> {
    List<BillEntity> findByUserId(Long id);
    List<BillEntity> findByClientId(Long id);
    List<BillEntity> findByCreationDate(LocalDateTime dateTime);
    List<BillEntity> findByProduct(Long id);
    List<BillEntity> findByPaymentMethod(String payment);
}
