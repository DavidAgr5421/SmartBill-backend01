package sena.facturacion.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.Report;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ReportCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.ReportResponse;

@Mapper(componentModel = "spring")
public interface ReportRestMapper {

    ReportResponse toResponse(Report domain);
    Report toDomain(ReportCreateRequest request);

    default Page<ReportResponse> toPageResponse(Page<Report> domainPage){
        return domainPage.map(this::toResponse);
    }

}
