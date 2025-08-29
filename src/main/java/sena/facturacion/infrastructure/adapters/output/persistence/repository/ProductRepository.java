package sena.facturacion.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sena.facturacion.infrastructure.adapters.output.persistence.entity.ProductEntity;

import java.math.BigInteger;
import java.time.LocalDateTime;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Page<ProductEntity> findByName(Pageable pageable, String name);
}
