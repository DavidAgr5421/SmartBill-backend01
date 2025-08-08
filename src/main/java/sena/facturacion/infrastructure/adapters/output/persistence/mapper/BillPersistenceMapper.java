package sena.facturacion.infrastructure.adapters.output.persistence.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.Bill;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.BillEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillPersistenceMapper {

    BillEntity toBillEntity(Bill domain);
    Bill toBill(BillEntity entity);

    default Page<Bill> toDomainPage(Page<BillEntity> entities){
        return entities.map(this::toBill);
    }
}
