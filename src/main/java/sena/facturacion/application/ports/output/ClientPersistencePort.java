package sena.facturacion.application.ports.output;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.Client;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ClientPersistencePort {

    Optional<Client> findById(Long id);
    Page<Client> findAll(Pageable pageable);
    Page<Client> filter(Pageable pageable, String name, String address);

    Client save(Client client);
    void deleteById(Long id);
}
