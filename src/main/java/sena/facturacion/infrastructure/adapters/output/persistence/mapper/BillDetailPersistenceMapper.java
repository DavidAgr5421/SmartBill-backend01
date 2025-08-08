package sena.facturacion.infrastructure.adapters.output.persistence.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.BillDetail;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.BillDetailEntity;

@Mapper(componentModel = "spring")
public interface BillDetailPersistenceMapper {

    BillDetailEntity toDetailEntity(BillDetail domain);
    BillDetail toDetail(BillDetailEntity entity);

    default Page<BillDetail> toDomainPage(Page<BillDetailEntity> entities) {
        return entities.map(this::toDetail);
    }
}
