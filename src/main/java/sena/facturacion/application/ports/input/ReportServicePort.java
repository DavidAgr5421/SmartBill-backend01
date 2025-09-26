package sena.facturacion.application.ports.input;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.Report;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Report.ReportSearchRequest;

public interface ReportServicePort {
    Report findById(Long id);
    Page<Report> findAll(Pageable pageable);
    Page<Report> search(Pageable pageable, ReportSearchRequest request);

    Report save(Report report);
    Report update(Long id, Report report);

    void deleteById(Long id);
}
