package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sena.facturacion.application.ports.input.BillServicePort;
import sena.facturacion.application.ports.output.BillPersistencePort;
import sena.facturacion.application.ports.output.ClientPersistencePort;
import sena.facturacion.application.ports.output.UserPersistencePort;
import sena.facturacion.domain.exception.BillNotFoundException;
import sena.facturacion.domain.model.Bill;
import sena.facturacion.domain.model.Client;
import sena.facturacion.domain.model.User;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class    BillService implements BillServicePort {

    private final ClientPersistencePort clientPersistencePort;
    private final UserPersistencePort userPersistencePort;
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
        Optional<User> user = userPersistencePort.findById(bill.getUserId().getId());
        Optional<Client> client = clientPersistencePort.findById(bill.getClientId().getId());
        if (user.isPresent() && client.isPresent()){
            bill.setUserId(user.get());
            bill.setClientId(client.get());
        }
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
