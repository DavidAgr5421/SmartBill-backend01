package sena.facturacion.infrastructure.adapters.output.persistence.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.Client;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.ClientEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientPersistenceMapper {

    ClientEntity toEntity(Client domain);
    Client toDomain(ClientEntity entity);

    List<Client> toDomain(List<ClientEntity> entities);

    default Page<Client> toDomainPage(Page<ClientEntity> entities){ return entities.map(this::toDomain);}
}
