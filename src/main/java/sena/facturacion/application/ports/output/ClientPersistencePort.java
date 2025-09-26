package sena.facturacion.application.ports.output;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.Client;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Client.ClientSearchRequest;

import java.util.Optional;

public interface ClientPersistencePort {

    Optional<Client> findById(Long id);
    Page<Client> findAll(Pageable pageable);
    Page<Client> search(Pageable pageable, ClientSearchRequest request);
    boolean existsByClientId(Long id);

    Client save(Client client);
    void deleteById(Long id);
}
