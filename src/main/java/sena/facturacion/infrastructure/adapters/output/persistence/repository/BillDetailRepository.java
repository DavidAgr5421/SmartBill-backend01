package sena.facturacion.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.BillDetailEntity;

import java.math.BigInteger;

public interface BillDetailRepository extends JpaRepository<BillDetailEntity, Long>, JpaSpecificationExecutor<BillDetailEntity> {
}
