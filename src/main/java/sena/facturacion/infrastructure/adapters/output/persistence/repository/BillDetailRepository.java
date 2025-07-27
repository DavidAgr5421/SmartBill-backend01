package sena.facturacion.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.BillDetailEntity;

public interface BillDetailRepository extends JpaRepository<BillDetailEntity, Long> {
}
