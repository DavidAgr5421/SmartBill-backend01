package sena.facturacion.infrastructure.adapters.input.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.facturacion.application.ports.input.ReportServicePort;
import sena.facturacion.infrastructure.adapters.input.rest.mapper.ReportRestMapper;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ReportCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ReportSearchRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.ReportResponse;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportRestAdapter {

    private final ReportServicePort servicePort;
    private final ReportRestMapper restMapper;

    @GetMapping("/v1/api/{id}")
    public ReportResponse findById(@PathVariable Long id){
        return restMapper.toResponse(servicePort.findById(id));
    }

    @GetMapping("/v1/api")
    public Page<ReportResponse> findAll(Pageable pageable){
        return restMapper.toPageResponse(servicePort.findAll(pageable));
    }

    @PostMapping("/v1/api")
    public Page<ReportResponse> search(Pageable pageable, ReportSearchRequest request){
        return restMapper.toPageResponse(servicePort.search(pageable,request));
    }

    @PostMapping("/v1/api/save")
    public ReportResponse save(ReportCreateRequest request){
        return restMapper.toResponse(servicePort.save(restMapper.toDomain(request)));
    }

    @PutMapping("/v1/api/{id}")
    public ReportResponse update(@PathVariable Long id, @RequestBody @Valid ReportCreateRequest request){
        return restMapper.toResponse(servicePort.update(id,restMapper.toDomain(request)));
    }

    @DeleteMapping("/v1/api/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return ResponseEntity.ok("The Report with ID: "+id+" deleted succesfully.");
    }
}
