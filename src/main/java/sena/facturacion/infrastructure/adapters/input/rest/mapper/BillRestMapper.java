package sena.facturacion.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.Bill;
import sena.facturacion.domain.model.Client;
import sena.facturacion.domain.model.User;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.BillResponse;

@Mapper(componentModel = "spring")
public interface BillRestMapper {

    BillResponse toBillResponse(Bill domain);
    default Bill toBill(BillCreateRequest request){
        User user = new User();
        user.setId(request.getUserId());
        Client client = new Client();
        client.setId(request.getClientId());

        return Bill.builder()
                .userId(user)
                .clientId(client)
                .total(request.getTotal())
                .paymentMethod(request.getPaymentMethod())
                .build();
    };

    default Page<BillResponse> toResponsePage(Page<Bill> domainPage){
        return domainPage.map(this::toBillResponse);
    }
}
