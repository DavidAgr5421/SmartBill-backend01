package sena.facturacion.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sena.facturacion.application.ports.output.ClientPersistencePort;
import sena.facturacion.domain.model.Client;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Client.ClientSearchRequest;
import sena.facturacion.infrastructure.adapters.output.persistence.mapper.ClientPersistenceMapper;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.ClientRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.specification.ClientSpecification;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClientPersistenceAdapter implements ClientPersistencePort {

    private final ClientRepository repository;
    private final ClientPersistenceMapper mapper;

    @Override
    public Optional<Client> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Client> findAll() {
        return mapper.toDomain(repository.findAll());
    }

    @Override
    public Page<Client> search(Pageable pageable, ClientSearchRequest request) {
        return mapper.toDomainPage(repository.findAll(ClientSpecification.withFilters(request), pageable));
    }

    @Override
    public boolean existsByClientId(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Client save(Client client) {
        return mapper.toDomain(repository.save(mapper.toEntity(client)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
