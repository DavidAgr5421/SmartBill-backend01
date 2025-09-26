package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sena.facturacion.application.mapper.ReportServiceMapper;
import sena.facturacion.application.ports.input.ReportServicePort;
import sena.facturacion.application.ports.output.ReportPersistencePort;
import sena.facturacion.domain.exception.ReportNotFoundException;
import sena.facturacion.domain.model.Bill;
import sena.facturacion.domain.model.Product;
import sena.facturacion.domain.model.Report;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Bill.BillSearchRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Report.ReportSearchRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService implements ReportServicePort {

    private final ReportPersistencePort persistencePort;
    private final BillService billService;
    private final ProductService productService;
    private final ReportServiceMapper mapper;

    @Override
    public Report findById(Long id) {
        return persistencePort.findById(id).orElseThrow(ReportNotFoundException::new);
    }

    @Override
    public Page<Report> findAll(Pageable pageable) {
        return persistencePort.findAll(pageable);
    }

    @Override
    public Page<Report> search(Pageable pageable, ReportSearchRequest request) {
        return persistencePort.search(pageable,request);
    }

    @Override
    public Report save(Report report) {
        Page<Bill> allYearBills = billService.search(Pageable.unpaged(),
                new BillSearchRequest(null,null,
                        null,null,null,
                        null,LocalDateTime.now().withDayOfYear(1),LocalDateTime.now(),null));
        Page<Product> allProducts = productService.findAll(Pageable.unpaged());

        List<String> onStockProducts = allProducts.getContent().stream().map(Product::getName).toList();

        report.setCreatedAt(LocalDateTime.now());
        report.setTotalSales(BigDecimal.valueOf(allYearBills.getContent().stream().mapToDouble(Bill::getTotal).sum()));
        report.setMonthSales(BigDecimal.valueOf(allYearBills.stream().filter(bill -> {
            return YearMonth.from(bill.getCreationDate()).equals(YearMonth.now());
        }).mapToDouble(Bill::getTotal).sum()));
        report.setProductOnStock(onStockProducts);
        report.setProductOnLowStock(allProducts.getContent().stream().filter(product ->
            product.getAmount().compareTo(report.getOnLowStockValue()) <= 0).map(Product::getName).toList());

        return persistencePort.save(report);
    }

    @Override
    public Report update(Long id, Report report) {
        return persistencePort.findById(id).map(foundReport ->{
            mapper.updateReportFromDto(report, foundReport);
            return persistencePort.save(foundReport);
        }).orElseThrow(ReportNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        persistencePort.deleteById(id);
    }
}
