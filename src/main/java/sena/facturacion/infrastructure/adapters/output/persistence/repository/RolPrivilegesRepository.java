package sena.facturacion.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.RolPrivilegesEntity;

public interface RolPrivilegesRepository extends JpaRepository<RolPrivilegesEntity, Long> {
}
