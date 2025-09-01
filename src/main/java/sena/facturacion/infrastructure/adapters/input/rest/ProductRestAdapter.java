package sena.facturacion.infrastructure.adapters.input.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.facturacion.application.ports.input.ProductServicePort;
import sena.facturacion.infrastructure.adapters.input.rest.mapper.ProductRestMapper;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ProductCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ProductPutRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ProductSearchRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.ProductResponse;

import java.math.BigInteger;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductRestAdapter {

    private final ProductServicePort servicePort;
    private final ProductRestMapper restMapper;

    @GetMapping("/v1/api/{id}")
    public ProductResponse findById(@PathVariable Long id){
        return restMapper.toResponse(servicePort.findById(id));
    }

    @GetMapping("/v1/api/all")
    public Page<ProductResponse> findAll(Pageable pageable){
        return restMapper.toPageResponse(servicePort.findAll(pageable));
    }

    @PostMapping("/v1/api/search")
    public Page<ProductResponse> search(Pageable pageable, @Valid @RequestBody ProductSearchRequest request){
        return restMapper.toPageResponse(servicePort.search(pageable,request));
    }

    @PostMapping("/v1/api")
    public ProductResponse save(@Valid @RequestBody ProductCreateRequest request){
        return restMapper.toResponse(servicePort.save(restMapper.toDomain(request)));
    }

    @PutMapping("/v1/api/{id}")
    public ProductResponse update(@PathVariable Long id, @Valid@RequestBody ProductPutRequest request){
        return restMapper.toResponse(servicePort.update(id,restMapper.toDomainPut(request)));
    }

    @DeleteMapping("/v1/api/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        servicePort.deleteById(id);
        return ResponseEntity.ok("Product with ID: "+id+" deleted succesfully.");
    }
}
