package sena.facturacion.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sena.facturacion.application.ports.output.ProductPersistencePort;
import sena.facturacion.domain.model.Product;
import sena.facturacion.infrastructure.adapters.output.persistence.mapper.ProductPersistenceMapper;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.ProductRepository;

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
    public Page<Product> findAll(Pageable pageable) {
        return mapper.toDomainPage(repository.findAll(pageable));
    }

    @Override
    public Page<Product> filter(Pageable pageable, String name) {
        return mapper.toDomainPage(repository.filter(pageable,name));
    }

    @Override
    public Product save(Product product) {
        return mapper.toDomain(repository.save(mapper.toEntity(product)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
