package sena.facturacion.infrastructure.adapters.input.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sena.facturacion.application.ports.input.BillServicePort;
import sena.facturacion.domain.model.Bill;
import sena.facturacion.infrastructure.adapters.input.rest.mapper.BillRestMapper;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.BillResponse;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillRestAdapter{

    private final BillServicePort servicePort;
    private final BillRestMapper restMapper;

    @GetMapping("/v1/api/{id}")
    public BillResponse findById(@PathVariable Long id){
        return restMapper.toBilResponse(servicePort.findById(id));
    }

    @GetMapping("/v1/api/user/{id}")
    public List<BillResponse> findByUserId(@PathVariable Long id){
        return restMapper.toBillResponseList(servicePort.findByUserId(id));
    }

    @GetMapping("/v1/api/client/{id}")
    public List<BillResponse> findByClientId(@PathVariable Long id){
        return restMapper.toBillResponseList(servicePort.findByClientId(id));
    }

    @GetMapping("/v1/api")
    public List<BillResponse> findAll(){
        return restMapper.toBillResponseList(servicePort.findAll());
    }

    @GetMapping("/v1/api/product/{id}")
    public List<BillResponse> findByProduct(@PathVariable Long id){
        return  restMapper.toBillResponseList(servicePort.findByProduct(id));
    }

    @GetMapping("/v1/api/payment/{payment}")
    public List<BillResponse> findByPaymentMethod(@PathVariable String payment){
        return restMapper.toBillResponseList(servicePort.findByPaymentMethod(payment));
    }

    @PutMapping("/v1/api/")
    public BillResponse save(@Valid @RequestBody Bill bill){
        return restMapper.toBilResponse(servicePort.save(bill));
    }

}
