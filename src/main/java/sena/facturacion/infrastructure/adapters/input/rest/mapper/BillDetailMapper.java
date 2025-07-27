package sena.facturacion.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import sena.facturacion.domain.model.BillDetail;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillDetailCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.BillDetailResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillDetailMapper {

    BillDetailResponse toDetailResponse(BillDetail domain);
    BillDetail toDetail(BillDetailCreateRequest request);

    List<BillDetailResponse> toDetailResponseList(List<BillDetail> domainList);
}
