package sena.facturacion.application.ports.input;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.BillDetail;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Bill.BillDetailSearchRequest;

import java.util.List;

public interface BillDetailServicePort {

    BillDetail findById(Long id);
    Page<BillDetail> findAll(Pageable pageable);
    List<BillDetail> search(BillDetailSearchRequest request);

    BillDetail save(BillDetail detail);
    BillDetail update(Long id,BillDetail detail);

    void deleteById(Long id);
}
