package sena.facturacion.application.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import sena.facturacion.domain.model.Configuration;

@Mapper(componentModel = "spring")
public interface ConfigServiceMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateConfigFromDto(Configuration source,@MappingTarget Configuration target);
}
