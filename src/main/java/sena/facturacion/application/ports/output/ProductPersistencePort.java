package sena.facturacion.application.ports.output;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.Product;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Product.ProductSearchRequest;

import java.util.List;
import java.util.Optional;

public interface ProductPersistencePort {
    Optional<Product> findById(Long id);
    List<Product> findAll();
    Page<Product> search(Pageable pageable, ProductSearchRequest request);
    boolean existsByProductId(Long id);

    Product save(Product product);
    void deleteById(Long id);
}
