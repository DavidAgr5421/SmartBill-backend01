package sena.facturacion.infrastructure.adapters.input.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.facturacion.application.ports.input.BillDetailServicePort;
import sena.facturacion.infrastructure.adapters.input.rest.mapper.BillDetailRestMapper;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillDetailCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillDetailPutRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.BillDetailResponse;

import java.math.BigInteger;

@RestController
@RequestMapping("/bill/detail")
@RequiredArgsConstructor
public class BillDetailRestAdapter {

    private final BillDetailServicePort servicePort;
    private final BillDetailRestMapper restMapper;

    @GetMapping("/{id}")
    public BillDetailResponse findByBillId(@PathVariable Long id){
        return restMapper.toDetailResponse(servicePort.findById(id));
    }

    @GetMapping("/history")
    public Page<BillDetailResponse> findAll(Pageable pageable){
        return restMapper.toDetailResponsePage(servicePort.findAll(pageable));
    }

    @GetMapping
    public Page<BillDetailResponse> filter(Pageable pageable,
                                           @RequestParam(required = false) Long id,
                                           @RequestParam(required = false) Long productId,
                                           @RequestParam(required = false) Long unitPrice,
                                           @RequestParam(required = false) BigInteger amount,
                                           @RequestParam(required = false) Long subTotal){
        return restMapper.toDetailResponsePage(servicePort.filter(pageable, id, productId,amount,unitPrice,subTotal));
    }

    @PutMapping
    public BillDetailResponse save(@RequestBody @Valid BillDetailCreateRequest detailRequest){
        return  restMapper.toDetailResponse(servicePort.save(restMapper.toDetail(detailRequest)));
    }

    @PutMapping("/{id}")
    public BillDetailResponse update(@RequestBody @Valid BillDetailPutRequest detailPutRequest, @PathVariable Long id){
        return  restMapper.toDetailResponse(servicePort.update(id,restMapper.putToDetail(detailPutRequest)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        servicePort.deleteById(id);
        return  ResponseEntity.ok("Bill with ID:"+id+" deleted successfully.");
    }
}
