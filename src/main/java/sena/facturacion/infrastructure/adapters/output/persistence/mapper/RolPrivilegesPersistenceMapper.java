package sena.facturacion.infrastructure.adapters.output.persistence.mapper;


import org.mapstruct.Mapper;
import sena.facturacion.domain.model.RolPrivileges;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.RolPrivilegesEntity;

@Mapper(componentModel = "spring")
public interface RolPrivilegesPersistenceMapper {

    RolPrivileges toRolPrivileges(RolPrivilegesEntity entity);
    RolPrivilegesEntity toRolPrivilegesEntity(RolPrivileges domain);

}
