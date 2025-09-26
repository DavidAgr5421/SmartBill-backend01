package sena.facturacion.application.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import sena.facturacion.domain.model.Product;

@Mapper(componentModel = "spring")
public interface ProductServiceMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductFromDto(Product source,@MappingTarget Product target);
}
