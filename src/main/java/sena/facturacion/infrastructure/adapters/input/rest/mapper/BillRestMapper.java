package sena.facturacion.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import sena.facturacion.domain.model.Bill;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.BillResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillRestMapper {

    BillResponse toBilResponse(Bill domain);
    Bill toBill(BillCreateRequest request);

    List<BillResponse> toBillResponseList(List<Bill> billList);
}
