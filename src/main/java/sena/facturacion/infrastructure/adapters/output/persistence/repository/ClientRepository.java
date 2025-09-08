package sena.facturacion.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.ClientEntity;

import java.time.LocalDateTime;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query(value = """
   SELECT c FROM ClientEntity c
                 WHERE (:name IS NULL OR :name = '' OR c.name = :name)
                     AND (:address IS NULL OR :address = '' OR c.address = :address)
                     AND (:contact IS NULL OR :contact = '' OR c.contact = :contact)
   """)
    Page<ClientEntity> filter(Pageable pageable,
                              @Param("name") String name,
                              @Param("address") String address,
                              @Param("contact") String contact,
                              @Param("startDate") LocalDateTime startDate,
                              @Param("endDate") LocalDateTime endDate);
}