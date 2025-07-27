package sena.facturacion.infrastructure.adapters.output.persistence.mapper;

import org.mapstruct.Mapper;
import sena.facturacion.domain.model.Bill;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.BillEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillPersistenceMapper {

    BillEntity toBillEntity(Bill domain);
    Bill toBill(BillEntity entity);

    List<Bill> toBillList(List<BillEntity> entityList);
}
