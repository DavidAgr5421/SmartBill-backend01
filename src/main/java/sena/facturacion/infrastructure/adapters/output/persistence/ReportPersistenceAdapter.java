package sena.facturacion.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sena.facturacion.application.ports.output.ReportPersistencePort;
import sena.facturacion.domain.model.Report;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Report.ReportSearchRequest;
import sena.facturacion.infrastructure.adapters.output.persistence.mapper.ReportPersistenceMapper;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.ReportRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.specification.ReportSpecification;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReportPersistenceAdapter implements ReportPersistencePort {

    private final ReportRepository repository;
    private final ReportPersistenceMapper mapper;

    @Override
    public Optional<Report> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Page<Report> findAll(Pageable pageable) {
        return mapper.toDomainPage(repository.findAll(pageable));
    }

    @Override
    public Page<Report> search(Pageable pageable, ReportSearchRequest request) {
        return mapper.toDomainPage(repository.findAll(ReportSpecification.withFilters(request),pageable));
    }

    @Override
    public Report save(Report report) {
        return mapper.toDomain(repository.save(mapper.toEntity(report)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
