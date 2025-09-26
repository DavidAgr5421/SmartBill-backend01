package sena.facturacion.application.mapper;

import org.mapstruct.*;
import sena.facturacion.domain.model.User;

@Mapper(componentModel = "spring")
public interface UserServiceMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "rolId", ignore = true)
    void updateUserFromDto(User source,@MappingTarget User target);
}
