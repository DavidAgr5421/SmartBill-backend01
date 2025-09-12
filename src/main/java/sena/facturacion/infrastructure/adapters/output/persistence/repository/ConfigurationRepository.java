package sena.facturacion.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.ConfigurationEntity;

public interface ConfigurationRepository  extends JpaRepository<ConfigurationEntity, Long> {
}
