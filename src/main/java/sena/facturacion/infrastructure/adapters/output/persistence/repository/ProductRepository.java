package sena.facturacion.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sena.facturacion.infrastructure.adapters.output.persistence.entity.ProductEntity;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query("""
            SELECT p FROM ProductEntity p
            WHERE (:name IS NULL OR p.name = :name)
            """)
    Page<ProductEntity> filter(Pageable pageable, String name);
}
