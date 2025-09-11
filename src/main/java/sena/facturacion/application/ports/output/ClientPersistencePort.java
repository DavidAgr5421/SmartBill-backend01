package sena.facturacion.application.ports.output;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.Client;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ClientSearchRequest;

import java.util.Optional;

public interface ClientPersistencePort {

    Optional<Client> findById(Long id);
    Page<Client> findAll(Pageable pageable);
    Page<Client> search(Pageable pageable, ClientSearchRequest request);

    Client save(Client client);
    void deleteById(Long id);
}
