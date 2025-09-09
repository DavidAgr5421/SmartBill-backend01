package sena.facturacion.infrastructure.adapters.input.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.facturacion.application.ports.input.BillServicePort;
import sena.facturacion.infrastructure.adapters.input.rest.mapper.BillRestMapper;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillSearchRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.BillResponse;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/bill")
@RequiredArgsConstructor
public class BillRestAdapter{

    private final BillServicePort servicePort;
    private final BillRestMapper restMapper;

    @GetMapping("/v1/api/{id}")
    public BillResponse findById(@PathVariable Long id){
        return restMapper.toBillResponse(servicePort.findById(id));
    }


    @PostMapping("/v1/api")
    public Page<BillResponse> search(Pageable pageable,
                                     @Valid @RequestBody BillSearchRequest request){
        return restMapper.toResponsePage(servicePort.search(pageable,request));
    }

    @GetMapping("/v1/api/all")
    public Page<BillResponse> findAll(Pageable pageable){
        return restMapper.toResponsePage(servicePort.findAll(pageable));
    }

    @PostMapping("/v1/api/new")
    public BillResponse save(@Valid @RequestBody BillCreateRequest request){
        return restMapper.toBillResponse(servicePort.save(restMapper.toBill(request)));
    }

    @PutMapping("/v1/api/{id}")
    public BillResponse update(@PathVariable Long id, @Valid @RequestBody BillCreateRequest request){
        return restMapper.toBillResponse(servicePort.update(id,restMapper.toBill(request)));
    }

    @DeleteMapping("/v1/api/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        servicePort.deleteById(id);
        return ResponseEntity.ok("Bill with ID: "+id+" deleted successfully.");
    }

}
