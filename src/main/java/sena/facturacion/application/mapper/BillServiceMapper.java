package sena.facturacion.application.mapper;

import org.mapstruct.*;
import sena.facturacion.domain.model.Bill;

@Mapper(componentModel = "spring")
public interface BillServiceMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "clientId", ignore = true)
    @Mapping(target = "userId", ignore = true)
    void updateBillFromDto(Bill source, @MappingTarget Bill target);

}
