package sena.facturacion.infrastructure.adapters.input.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.facturacion.application.ports.input.ConfigurationServicePort;
import sena.facturacion.infrastructure.adapters.input.rest.mapper.ConfigurationRestMapper;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.ConfigurationPutRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.ConfigurationResponse;

@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
public class ConfigurationRestAdapter {

    private final ConfigurationServicePort servicePort;
    private final ConfigurationRestMapper restMapper;

    @GetMapping("/v1/api/{id}")
    public ConfigurationResponse findById(@PathVariable Long id){
        return restMapper.toResponse(servicePort.findById(id));
    }
    @GetMapping("/v1/api")
    public Page<ConfigurationResponse> findAll(Pageable pageable){
        return restMapper.toResponsePage(servicePort.findAll(pageable));
    }

    @PostMapping("/v1/api")
    public ConfigurationResponse save(@RequestBody @Valid ConfigurationPutRequest request){
        return restMapper.toResponse(servicePort.save(restMapper.toDomain(request)));
    }

    @PutMapping("/v1/api/{id}")
    public ConfigurationResponse update(@PathVariable Long id,@RequestBody @Valid ConfigurationPutRequest request){
        return restMapper.toResponse(servicePort.update(id,restMapper.toDomain(request)));
    }

    @DeleteMapping("/v1/api/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        servicePort.deleteById(id);
        return ResponseEntity.ok("Configuration with ID: "+id+" deleted succesfully.");
    }
}
