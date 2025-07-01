package sena.facturacion.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.UserRolEntity;

public interface UserRolRepository extends JpaRepository<UserRolEntity, Long> {
}
