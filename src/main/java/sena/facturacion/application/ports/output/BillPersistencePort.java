package sena.facturacion.application.ports.output;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.Bill;
import sena.facturacion.domain.model.BillDetail;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillSearchRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BillPersistencePort {

    Optional<Bill> findById(Long id);

    Page<Bill> findAll(Pageable pageable);

    Page<Bill> search(Pageable pageable, BillSearchRequest request);

    Bill save(Bill bill);
    void deleteById(Long id);
}
