package sena.facturacion.application.ports.input;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.Configuration;

public interface ConfigurationServicePort {
    Configuration findById(Long id);
    Page<Configuration> findAll(Pageable pageable);

    Configuration save(Configuration config);
    Configuration update(Long id,Configuration config);

    void deleteById(Long id);
}
