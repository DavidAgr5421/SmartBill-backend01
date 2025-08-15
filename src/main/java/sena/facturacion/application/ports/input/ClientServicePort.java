package sena.facturacion.application.ports.input;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.Client;

import java.time.LocalDateTime;

public interface ClientServicePort {
    Client findById(Long id);
    Page<Client> findAll(Pageable pageable);
    Page<Client> filter(Pageable pageable, String name, String address, String contact, LocalDateTime startDate, LocalDateTime endDate);

    Client save(Client client);
    Client update(Long id, Client client);

    void deleteById(Long id);
}
