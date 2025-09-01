package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sena.facturacion.application.ports.input.ProductServicePort;
import sena.facturacion.application.ports.output.ProductPersistencePort;
import sena.facturacion.domain.exception.ProductNotFoundException;
import sena.facturacion.domain.model.Product;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ProductSearchRequest;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServicePort {

    private final ProductPersistencePort persistencePort;


    @Override
    public Product findById(Long id) {
        return persistencePort.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return persistencePort.findAll(pageable);
    }

    @Override
    public Page<Product> search(Pageable pageable, ProductSearchRequest request) {
        return persistencePort.search(pageable,request);
    }

    @Override
    public Product save(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        return persistencePort.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        return persistencePort.findById(id).map(searchedProduct ->{
            searchedProduct.setName(product.getName());
            searchedProduct.setUpdatedAt(LocalDateTime.now());
            searchedProduct.setAmount(product.getAmount());
            searchedProduct.setReferenceNo(product.getReferenceNo());
            return persistencePort.save(searchedProduct);
        }).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        persistencePort.deleteById(id);
    }
}
