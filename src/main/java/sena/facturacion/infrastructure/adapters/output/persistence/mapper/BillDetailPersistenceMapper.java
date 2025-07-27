package sena.facturacion.infrastructure.adapters.output.persistence.mapper;

import org.mapstruct.Mapper;
import sena.facturacion.domain.model.BillDetail;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.BillDetailEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillDetailPersistenceMapper {

    BillDetailEntity toDetaiLEntity(BillDetail domain);
    BillDetail toDetail(BillDetailEntity entity);

    List<BillDetail> toDetailList(List<BillDetailEntity> entityList);
}
