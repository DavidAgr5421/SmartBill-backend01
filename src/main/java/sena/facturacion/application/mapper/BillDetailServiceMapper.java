package sena.facturacion.application.mapper;

import org.mapstruct.*;
import sena.facturacion.domain.model.BillDetail;

@Mapper(componentModel = "spring")
public interface BillDetailServiceMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "billId", ignore = true)
    @Mapping(target = "productId", ignore = true)
    void updateBillDetailFromDto(BillDetail source,@MappingTarget  BillDetail target);
}
