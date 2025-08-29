package sena.facturacion.application.ports.input;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.Product;

import java.math.BigInteger;
import java.time.LocalDateTime;

public interface ProductServicePort {

    Product findById(Long id);
    Page<Product> findAll(Pageable pageable);
    Page<Product> filter(Pageable pageable, String name, String referenceNo, BigInteger amount, LocalDateTime startDate, LocalDateTime endDate);

    Product save(Product product);
    Product update(Long id, Product product);

    void deleteById(Long id);
}
