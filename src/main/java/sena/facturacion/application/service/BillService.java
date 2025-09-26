package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sena.facturacion.application.mapper.BillServiceMapper;
import sena.facturacion.application.ports.input.BillServicePort;
import sena.facturacion.application.ports.output.BillPersistencePort;
import sena.facturacion.domain.exception.Bill.BillNotFoundException;
import sena.facturacion.domain.model.Bill;
import sena.facturacion.domain.model.BillDetail;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Bill.BillDetailSearchRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Bill.BillSearchRequest;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BillService implements BillServicePort {

    private final ClientService clientService;
    private final UserService userService;
    private final BillPersistencePort persistencePort;
    private final BillDetailService detailService;
    private final BillServiceMapper mapper;

    @Override
    public Bill findById(Long id) {
        return persistencePort.findById(id).orElseThrow(BillNotFoundException::new);
    }

    @Override
    public Page<Bill> findAll(Pageable pageable) {
        return persistencePort.findAll(pageable);
    }

    @Override
    public Page<Bill> search(Pageable pageable, BillSearchRequest request) {
        return persistencePort.search(pageable,request);
    }

    @Override
    public List<BillDetail> detailsById(Long id, BillDetailSearchRequest request) {
        request.setBillId(id);
        return detailService.search(request);
    }

    @Override
    public Bill save(Bill bill) {
        bill.setClientId(clientService.findById(bill.getClientId().getId()));
        bill.setUserId(userService.findById(bill.getUserId().getId()));
        bill.setCreationDate(LocalDateTime.now());
        return persistencePort.save(bill);
    }

    @Override
    public Bill update(Long id, Bill bill) {
        return persistencePort.findById(id).map(searchedBill -> {
            if(bill.getClientId().getId() != null){
                var clientRef = clientService.findById(bill.getClientId().getId());
                searchedBill.setClientId(clientRef);
            }
            if(bill.getUserId().getId() != null){
                var userRef = userService.findById(bill.getUserId().getId());
                searchedBill.setUserId(userRef);
            }
            mapper.updateBillFromDto(bill,searchedBill);
            return persistencePort.save(searchedBill);
        }).orElseThrow(BillNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        persistencePort.deleteById(id);
    }
}
