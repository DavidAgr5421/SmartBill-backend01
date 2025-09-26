package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sena.facturacion.application.mapper.ConfigServiceMapper;
import sena.facturacion.application.ports.input.ConfigurationServicePort;
import sena.facturacion.application.ports.output.ConfigurationPersistencePort;
import sena.facturacion.domain.exception.ConfigurationNotFoundException;
import sena.facturacion.domain.model.Configuration;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ConfigurationService implements ConfigurationServicePort {

    private final ConfigurationPersistencePort persistencePort;
    private final ConfigServiceMapper mapper;

    @Override
    public Configuration findById(Long id) {
        return persistencePort.findById(id).orElseThrow(ConfigurationNotFoundException::new);
    }

    @Override
    public Page<Configuration> findAll(Pageable pageable) {
        return persistencePort.findAll(pageable);
    }

    @Override
    public Configuration save(Configuration config) {
        config.setCreatedAt(LocalDateTime.now());
        return persistencePort.save(config);
    }

    @Override
    public Configuration update(Long id, Configuration config) {
        return persistencePort.findById(id).map(searchedConfig ->{
            mapper.updateConfigFromDto(config,searchedConfig);
            return persistencePort.save(searchedConfig);
        }).orElseThrow(ConfigurationNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        persistencePort.deleteById(id);
    }
}
