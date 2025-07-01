package sena.facturacion.infrastructure.adapters.output.persistence.mapper;

import org.mapstruct.Mapper;
import sena.facturacion.domain.model.UserRol;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.UserRolEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRolPersistenceMapper {

    UserRolEntity toUserRolEntity(UserRol userRol);

    UserRol toUserRol(UserRolEntity userRolEntity);

    List<UserRol> toUserRolList(List<UserRolEntity> entityList);
}
