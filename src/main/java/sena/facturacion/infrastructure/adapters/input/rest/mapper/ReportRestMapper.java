package sena.facturacion.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.Report;
import sena.facturacion.domain.model.User;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Report.ReportCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Report.ReportPutRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.Report.ReportResponse;

@Mapper(componentModel = "spring")
public interface ReportRestMapper {

    ReportResponse toResponse(Report domain);

    default Report toDomain(ReportCreateRequest request){
        return Report.builder()
                .userId(new User(request.getUserId()))
                .observation(request.getObservation())
                .onLowStockValue(request.getOnLowStockValue())
                .build();
    }

    default Report toDomain(ReportPutRequest request){
        return Report.builder()
                .observation(request.getObservation())
                .build();
    }

    default Page<ReportResponse> toPageResponse(Page<Report> domainPage){
        return domainPage.map(this::toResponse);
    }

}
