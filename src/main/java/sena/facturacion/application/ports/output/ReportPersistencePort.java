package sena.facturacion.application.ports.output;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.Report;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ReportSearchRequest;

import java.util.Optional;

public interface ReportPersistencePort {
    Optional<Report> findById(Long id);
    Page<Report> findAll(Pageable pageable);
    Page<Report> search(Pageable pageable, ReportSearchRequest request);

    Report save(Report report);
    void deleteById(Long id);
}
