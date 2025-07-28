package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.facturacion.application.ports.input.BillServicePort;
import sena.facturacion.application.ports.output.BillPersistencePort;
import sena.facturacion.domain.exception.BillNotFoundException;
import sena.facturacion.domain.model.Bill;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService implements BillServicePort {

    private final BillPersistencePort persistencePort;

    @Override
    public Bill findById(Long id) {
        return persistencePort.findById(id).orElseThrow(BillNotFoundException::new);
    }

    @Override
    public List<Bill> findByUserId(Long id) {
        return persistencePort.findByUserId(id);
    }

    @Override
    public List<Bill> findByClientId(Long id) {
        return persistencePort.findByClientId(id);
    }

    @Override
    public List<Bill> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public List<Bill> findByCreationDate(LocalDateTime dateTime) {return persistencePort.findByCreationDate(dateTime);}

    @Override
    public List<Bill> findByProduct(Long productId) {
        return persistencePort.findByProduct(productId);
    }

    @Override
    public List<Bill> findByPaymentMethod(String payment) {
        return   persistencePort.findByPaymentMethod(payment);
    }

    @Override
    public Bill save(Bill bill) {
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
