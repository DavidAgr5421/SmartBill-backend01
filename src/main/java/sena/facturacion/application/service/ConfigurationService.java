package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sena.facturacion.application.ports.input.ConfigurationServicePort;
import sena.facturacion.application.ports.output.ConfigurationPersistencePort;
import sena.facturacion.domain.exception.ConfigurationNotFoundException;
import sena.facturacion.domain.model.Configuration;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ConfigurationService implements ConfigurationServicePort {

    private final ConfigurationPersistencePort persistencePort;

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
            searchedConfig.setContact(config.getContact());
            searchedConfig.setNit(config.getNit());
            searchedConfig.setFooter(config.getFooter());
            searchedConfig.setPaperWidth(config.getPaperWidth());
            searchedConfig.setFontSize(config.getFontSize());
            searchedConfig.setUpdatedAt(LocalDateTime.now());
            searchedConfig.setLogoType(config.getLogoType());
            searchedConfig.setQrType(config.getQrType());
            return persistencePort.save(searchedConfig);
        }).orElseThrow(ConfigurationNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        persistencePort.deleteById(id);
    }
}
