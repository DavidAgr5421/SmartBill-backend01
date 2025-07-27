package sena.facturacion.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.BillEntity;

public interface BillRepository extends JpaRepository<BillEntity, Long> {
}
