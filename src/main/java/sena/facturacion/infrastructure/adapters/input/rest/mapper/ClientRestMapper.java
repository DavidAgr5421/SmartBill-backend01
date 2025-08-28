package sena.facturacion.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.Client;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ClientPutRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ClientRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.ClientResponse;

@Mapper(componentModel = "spring")
public interface ClientRestMapper {

    ClientResponse toResponse(Client domain);
    Client toDomain(ClientRequest request);
    Client toDomainFrmPut(ClientPutRequest request);

    default Page<ClientResponse> toPageResponse(Page<Client> domainPage){return domainPage.map(this::toResponse);}
}
