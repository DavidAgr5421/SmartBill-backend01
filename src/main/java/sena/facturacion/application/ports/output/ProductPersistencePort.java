package sena.facturacion.application.ports.output;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.Product;

import java.util.Optional;

public interface ProductPersistencePort {
    Optional<Product> findById(Long id);
    Page<Product> findAll(Pageable pageable);
    Page<Product> filter(Pageable pageable,String name);

    Product save(Product product);
    void deleteById(Long id);
}
