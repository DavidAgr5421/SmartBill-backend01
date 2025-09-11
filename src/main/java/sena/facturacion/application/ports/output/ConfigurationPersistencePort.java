package sena.facturacion.application.ports.output;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.Configuration;

import java.util.Optional;

public interface ConfigurationPersistencePort {

    Optional<Configuration> findById(Long id);
    Page<Configuration> findAll(Pageable pageable);

    Configuration save(Configuration config);
    void deleteById(Long id);
}
