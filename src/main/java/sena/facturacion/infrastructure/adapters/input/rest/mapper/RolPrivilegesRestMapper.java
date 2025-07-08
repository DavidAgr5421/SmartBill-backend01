package sena.facturacion.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import sena.facturacion.domain.model.RolPrivileges;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.RolPrivilegesEntity;

@Mapper(componentModel = "spring")
public interface RolPrivilegesRestMapper {

    RolPrivilegesEntity toRolPrivelegesEntity(RolPrivileges privileges);

    RolPrivileges toRolPrivileges(RolPrivilegesEntity entity);
}
