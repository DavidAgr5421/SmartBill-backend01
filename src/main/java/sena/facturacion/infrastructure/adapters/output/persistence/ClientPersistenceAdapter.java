package sena.facturacion.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sena.facturacion.application.ports.output.ClientPersistencePort;
import sena.facturacion.domain.model.Client;
import sena.facturacion.infrastructure.adapters.output.persistence.mapper.ClientPersistenceMapper;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.ClientRepository;

import java.time.LocalDateTime;
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
    public Page<Client> findAll(Pageable pageable) {
        return mapper.toDomainPage(repository.findAll(pageable));
    }

    @Override
    public Page<Client> filter(Pageable pageable, String name, String address, String contact, LocalDateTime startDate, LocalDateTime endDate) {
        return mapper.toDomainPage(repository.filter(pageable,name,address,contact,startDate,endDate));
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
