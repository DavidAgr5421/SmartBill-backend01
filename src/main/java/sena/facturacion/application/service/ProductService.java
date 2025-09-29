package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sena.facturacion.application.mapper.ProductServiceMapper;
import sena.facturacion.application.ports.input.ProductServicePort;
import sena.facturacion.application.ports.output.ProductPersistencePort;
import sena.facturacion.domain.exception.Product.ProductNotFoundException;
import sena.facturacion.domain.model.Product;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Product.ProductSearchRequest;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServicePort {

    private final ProductPersistencePort persistencePort;
    private final ProductServiceMapper mapper;

    @Override
    public Product findById(Long id) {
        return persistencePort.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<Product> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Page<Product> search(Pageable pageable, ProductSearchRequest request) {
        return persistencePort.search(pageable,request);
    }

    @Override
    public Product save(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        product.setActive(true);
        return persistencePort.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        return persistencePort.findById(id).map(searchedProduct ->{
            mapper.updateProductFromDto(product, searchedProduct);
            return persistencePort.save(searchedProduct);
        }).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        var product = persistencePort.findById(id).orElseThrow(ProductNotFoundException::new);
        if(persistencePort.existsByProductId(id)){
            product.setActive(false);
            persistencePort.save(product);
        }else{
        persistencePort.deleteById(id);}
    }
}
