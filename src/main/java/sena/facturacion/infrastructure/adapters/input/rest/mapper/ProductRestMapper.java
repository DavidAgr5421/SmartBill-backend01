package sena.facturacion.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sena.facturacion.domain.model.Product;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Product.ProductCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Product.ProductPutRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.Product.ProductResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface    ProductRestMapper {

    ProductResponse toResponse(Product domain);

    Product toDomain(ProductCreateRequest request);

    Product toDomainPut(ProductPutRequest request);

    List<ProductResponse> toDomainList(List<Product> products);
    default Page<ProductResponse> toPageResponse(Page<Product> domainPage){
        return domainPage.map(this::toResponse);
    }
}
