package sena.facturacion.infrastructure.adapters.output.persistence.mapper;

import org.mapstruct.Mapper;
import sena.facturacion.domain.model.UserRol;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.UserRolEntity;

@Mapper(componentModel = "spring")
public interface UserRolPersistenceMapper {

    UserRolEntity toUserRolEntity(UserRol userRol);

    UserRol toUserRol(UserRolEntity userRolEntity);
}
