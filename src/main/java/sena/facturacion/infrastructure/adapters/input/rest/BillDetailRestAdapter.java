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
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillDetailSearchRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.BillDetailResponse;

import java.math.BigInteger;
import java.util.List;

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

    @GetMapping
    public List<BillDetailResponse> search(Pageable pageable,
                                           @RequestBody @Valid BillDetailSearchRequest request){
        return restMapper.toDetailResponseList(servicePort.search(request));
    }

    @PostMapping
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
