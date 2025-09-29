package sena.facturacion.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.Client;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Client.ClientPutRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Client.ClientRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.Client.ClientResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientRestMapper {

    ClientResponse toResponse(Client domain);
    Client toDomain(ClientRequest request);
    Client toDomainPut(ClientPutRequest request);

    List<ClientResponse> toResponseList(List<Client> clients);

    default Page<ClientResponse> toPageResponse(Page<Client> domainPage){return domainPage.map(this::toResponse);}
}
