package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sena.facturacion.application.ports.input.ReportServicePort;
import sena.facturacion.application.ports.output.ReportPersistencePort;
import sena.facturacion.domain.exception.ReportNotFoundException;
import sena.facturacion.domain.model.Report;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ReportSearchRequest;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReportService implements ReportServicePort {

    private final ReportPersistencePort persistencePort;

    @Override
    public Report findById(Long id) {
        return persistencePort.findById(id).orElseThrow(ReportNotFoundException::new);
    }

    @Override
    public Page<Report> findAll(Pageable pageable) {
        return persistencePort.findAll(pageable);
    }

    @Override
    public Page<Report> search(Pageable pageable, ReportSearchRequest request) {
        return persistencePort.search(pageable,request);
    }

    @Override
    public Report save(Report report) {
        report.setCreatedAt(LocalDateTime.now());
        return persistencePort.save(report);
    }

    @Override
    public Report update(Long id, Report report) {
        return persistencePort.findById(id).map(foundReport ->{
            foundReport.setTotalSales(report.getTotalSales());
            foundReport.setMonthSales(report.getMonthSales());
            foundReport.setObservation(report.getObservation());
            foundReport.setProductOnStock(report.getProductOnStock());
            foundReport.setProductOnLowStock(report.getProductOnLowStock());
            return persistencePort.save(foundReport);
        }).orElseThrow(ReportNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        persistencePort.deleteById(id);
    }
}
