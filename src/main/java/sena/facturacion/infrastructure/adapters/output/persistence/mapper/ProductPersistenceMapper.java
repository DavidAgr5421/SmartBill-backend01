package sena.facturacion.infrastructure.adapters.output.persistence.mapper;


import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.Product;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.ProductEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductPersistenceMapper {

    ProductEntity toEntity(Product domain);
    Product toDomain(ProductEntity entity);

    List<Product> toDomainPage(List<ProductEntity> productEntities);
    default Page<Product> toDomainPage(Page<ProductEntity> entityPage){
        return entityPage.map(this::toDomain);
    }
}
