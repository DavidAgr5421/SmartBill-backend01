package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sena.facturacion.application.mapper.ClientServiceMapper;
import sena.facturacion.application.ports.input.ClientServicePort;
import sena.facturacion.application.ports.output.ClientPersistencePort;
import sena.facturacion.domain.exception.Client.ClientNotFoundException;
import sena.facturacion.domain.model.Client;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Client.ClientSearchRequest;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService implements ClientServicePort {

    private final ClientPersistencePort persistencePort;
    private final ClientServiceMapper mapper;

    @Override
    public Client findById(Long id) {
        return persistencePort.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public List<Client> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Page<Client> search(Pageable pageable, ClientSearchRequest request) {
        return persistencePort.search(pageable,request);
    }

    @Override
    public Client save(Client client) {
        client.setCreationDate(LocalDateTime.now());
        client.setActive(true);
        return persistencePort.save(client);
    }

    @Override
    public Client update(Long id, Client client) {
       return persistencePort.findById(id).map(searchedClient ->{
           mapper.updateClientFromDto(client, searchedClient);
           return persistencePort.save(searchedClient);
       }).orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        var client = persistencePort.findById(id).orElseThrow(ClientNotFoundException::new);
        if(persistencePort.existsByClientId(id)){
            client.setActive(false);
            persistencePort.save(client);
        }else {persistencePort.deleteById(id);}
    }
}
