package sena.facturacion.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.Bill;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.BillResponse;

@Mapper(componentModel = "spring")
public interface BillRestMapper {

    BillResponse toBillResponse(Bill domain);
    Bill toBill(BillCreateRequest request);

    default Page<BillResponse> toResponsePage(Page<Bill> domainPage){
        return domainPage.map(this::toBillResponse);
    }
}
