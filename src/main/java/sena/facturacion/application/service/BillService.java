package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sena.facturacion.application.ports.input.BillServicePort;
import sena.facturacion.application.ports.output.BillPersistencePort;
import sena.facturacion.domain.exception.BillNotFoundException;
import sena.facturacion.domain.model.Bill;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class BillService implements BillServicePort {

    private final ClientService clientService;
    private final UserService userService;
    private final BillPersistencePort persistencePort;

    @Override
    public Bill findById(Long id) {
        return persistencePort.findById(id).orElseThrow(BillNotFoundException::new);
    }

    @Override
    public Page<Bill> findAll(Pageable pageable) {
        return persistencePort.findAll(pageable);
    }

    @Override
    public Page<Bill> filter(Pageable pageable,Long userId, Long clientId, LocalDateTime date, Long productId, String payment) {
        return persistencePort.filter(pageable,userId,clientId,date,productId,payment);
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
            searchedBill.setClientId(bill.getClientId());
            searchedBill.setUserId(bill.getUserId());
            searchedBill.setTotal(bill.getTotal());
            searchedBill.setCreationDate(bill.getCreationDate());
            searchedBill.setPaymentMethod(bill.getPaymentMethod());
            return persistencePort.save(searchedBill);
        }).orElseThrow(BillNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        persistencePort.deleteById(id);
    }
}
