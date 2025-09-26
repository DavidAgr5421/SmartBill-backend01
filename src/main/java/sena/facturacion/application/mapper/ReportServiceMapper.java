package sena.facturacion.application.mapper;

import org.mapstruct.*;
import sena.facturacion.domain.model.Report;

@Mapper(componentModel = "spring")
public interface ReportServiceMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "userId", ignore = true)
    void updateReportFromDto(Report source,@MappingTarget Report target);
}
