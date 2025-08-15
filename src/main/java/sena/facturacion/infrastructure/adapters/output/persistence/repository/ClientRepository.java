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
   SELECT * FROM client c
   WHERE (:name IS NULL OR c.name ILIKE :name)
     AND (:address IS NULL OR c.address ILIKE :address)
     AND (:contact IS NULL OR c.contact ILIKE :contact)
     AND (:startDate IS NULL OR :endDate IS NULL OR c.creation_date BETWEEN :startDate AND :endDate)
   ORDER BY c.creation_date DESC
   """, nativeQuery = true)
    Page<ClientEntity> filter(Pageable pageable,
                              @Param("name") String name,
                              @Param("address") String address,
                              @Param("contact") String contact,
                              @Param("startDate") LocalDateTime startDate,
                              @Param("endDate") LocalDateTime endDate);
}
