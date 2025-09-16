package sena.facturacion.infrastructure.adapters.output.persistence.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.Report;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.ReportEntity;

@Mapper(componentModel = "spring")
public interface ReportPersistenceMapper {

    ReportEntity toEntity(Report domain);
    Report toDomain(ReportEntity entity);

    default Page<Report> toDomainPage(Page<ReportEntity> entityPage){
        return entityPage.map(this::toDomain);
    }
}
