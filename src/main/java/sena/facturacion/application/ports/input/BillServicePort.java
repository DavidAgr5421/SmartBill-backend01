package sena.facturacion.application.ports.input;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sena.facturacion.domain.model.Bill;
import sena.facturacion.domain.model.BillDetail;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillDetailSearchRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillSearchRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface BillServicePort {

    Bill findById(Long id);
    Page<Bill> findAll(Pageable pageable);
    Page<Bill> search(Pageable pageable, BillSearchRequest request);
    List<BillDetail> detailsById(Long id, BillDetailSearchRequest request);

    Bill save(Bill bill);
    Bill update(Long id, Bill bill);

    void deleteById(Long id);
}