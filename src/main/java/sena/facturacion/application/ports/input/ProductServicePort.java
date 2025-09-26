package sena.facturacion.application.ports.input;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.Product;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Product.ProductSearchRequest;


public interface ProductServicePort {

    Product findById(Long id);
    Page<Product> findAll(Pageable pageable);
    Page<Product> search(Pageable pageable, ProductSearchRequest request);

    Product save(Product product);
    Product update(Long id, Product product);

    void deleteById(Long id);
}
