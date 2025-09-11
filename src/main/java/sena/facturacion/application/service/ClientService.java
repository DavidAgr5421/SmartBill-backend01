package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sena.facturacion.application.ports.input.ClientServicePort;
import sena.facturacion.application.ports.output.ClientPersistencePort;
import sena.facturacion.domain.exception.ClientNotFoundException;
import sena.facturacion.domain.model.Client;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ClientSearchRequest;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ClientService implements ClientServicePort {

    private final ClientPersistencePort persistencePort;

    @Override
    public Client findById(Long id) {
        return persistencePort.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return persistencePort.findAll(pageable);
    }

    @Override
    public Page<Client> search(Pageable pageable, ClientSearchRequest request) {
        return persistencePort.search(pageable,request);
    }

    @Override
    public Client save(Client client) {
        client.setCreationDate(LocalDateTime.now());
        return persistencePort.save(client);
    }

    @Override
    public Client update(Long id, Client client) {
       return persistencePort.findById(id).map(searchedClient ->{
           searchedClient.setName(client.getName());
           searchedClient.setAddress(client.getAddress());
           searchedClient.setContact(client.getContact());
           return persistencePort.save(searchedClient);
       }).orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        persistencePort.deleteById(id);
    }
}
