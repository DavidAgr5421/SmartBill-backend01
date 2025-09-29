package sena.facturacion.application.ports.input;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.Client;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Client.ClientSearchRequest;

import java.util.List;


public interface ClientServicePort {
    Client findById(Long id);
    List<Client> findAll();
    Page<Client> search(Pageable pageable, ClientSearchRequest request);

    Client save(Client client);
    Client update(Long id, Client client);

    void deleteById(Long id);
}
