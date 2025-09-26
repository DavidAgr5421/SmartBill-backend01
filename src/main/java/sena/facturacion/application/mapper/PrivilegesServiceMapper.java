package sena.facturacion.application.mapper;

import org.mapstruct.*;
import sena.facturacion.domain.model.RolPrivileges;

@Mapper(componentModel = "spring")
public interface PrivilegesServiceMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "rol",ignore = true)
    void updatePrivilegesFromDto(RolPrivileges source,@MappingTarget RolPrivileges target);
}
