package sena.facturacion.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sena.facturacion.application.ports.output.ProductPersistencePort;
import sena.facturacion.domain.model.Product;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Product.ProductSearchRequest;
import sena.facturacion.infrastructure.adapters.output.persistence.mapper.ProductPersistenceMapper;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.ProductRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.specification.ProductSpecification;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductPersistencePort {

    private final ProductRepository repository;
    private final ProductPersistenceMapper mapper;

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return mapper.toDomainPage(repository.findAll());
    }

    @Override
    public Product save(Product product) {
        return mapper.toDomain(repository.save(mapper.toEntity(product)));
    }

    @Override
    public Page<Product> search(Pageable pageable, ProductSearchRequest request) {
        return mapper.toDomainPage(repository.findAll(ProductSpecification.withFilters(request),pageable));
    }

    @Override
    public boolean existsByProductId(Long id) {
        return repository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
