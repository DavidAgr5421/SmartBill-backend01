package sena.facturacion.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.UserRolEntity;

import java.util.Optional;

public interface UserRolRepository extends JpaRepository<UserRolEntity, Long> {
    Optional<UserRolEntity> findByRolName(String rolName);
}
