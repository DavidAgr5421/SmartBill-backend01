package sena.facturacion.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByRolId_RolId(Long rolId);
}
