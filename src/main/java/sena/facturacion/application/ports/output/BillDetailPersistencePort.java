package sena.facturacion.application.ports.output;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.BillDetail;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillDetailSearchRequest;

import java.util.List;
import java.util.Optional;

public interface BillDetailPersistencePort {

    Optional<BillDetail> findById(Long id);
    Page<BillDetail> findAll(Pageable pageable);

    List<BillDetail> search(BillDetailSearchRequest request);

    BillDetail save(BillDetail billDetail);
    void deleteById(Long id);
}
