package sena.facturacion.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sena.facturacion.application.ports.output.ConfigurationPersistencePort;
import sena.facturacion.domain.model.Configuration;
import sena.facturacion.infrastructure.adapters.output.persistence.mapper.ConfigurationPersistenceMapper;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.ConfigurationRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ConfigurationPersistenceAdapter implements ConfigurationPersistencePort {

    private final ConfigurationRepository repository;
    private final ConfigurationPersistenceMapper mapper;

    @Override
    public Optional<Configuration> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Page<Configuration> findAll(Pageable pageable) {
        return mapper.toDomainPage(repository.findAll(pageable));
    }

    @Override
    public Configuration save(Configuration config) {
        return mapper.toDomain(repository.save(mapper.toEntity(config)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
