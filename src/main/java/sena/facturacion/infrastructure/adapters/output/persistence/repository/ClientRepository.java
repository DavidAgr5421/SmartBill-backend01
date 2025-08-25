package sena.facturacion.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    Page<ClientEntity> findByName(Pageable pageable,
                                  @Param("name") String name);
}
