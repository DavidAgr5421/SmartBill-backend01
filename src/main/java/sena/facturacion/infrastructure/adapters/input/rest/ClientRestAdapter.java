package sena.facturacion.infrastructure.adapters.input.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.facturacion.application.ports.input.ClientServicePort;
import sena.facturacion.infrastructure.adapters.input.rest.mapper.ClientRestMapper;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Client.ClientPutRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Client.ClientRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Client.ClientSearchRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.Client.ClientResponse;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientRestAdapter {

    private final ClientServicePort servicePort;
    private final ClientRestMapper restMapper;

    @GetMapping("/v1/api/{id}")
    public ClientResponse findById(@PathVariable Long id){
        return restMapper.toResponse(servicePort.findById(id));
    }

    @GetMapping("/v1/api")
    public List<ClientResponse> findAll(){
        return restMapper.toResponseList(servicePort.findAll());
    }

    @PostMapping("/v1/api")
    public Page<ClientResponse> search(Pageable pageable,
                                       @Valid @RequestBody ClientSearchRequest request){
        return restMapper.toPageResponse(servicePort.search(pageable,request));
    }

    @PostMapping("/v1/api/new")
    public ClientResponse save(@RequestBody @Valid ClientRequest request){
        return restMapper.toResponse(servicePort.save(restMapper.toDomain(request)));
    }

    @PutMapping("/v1/api/{id}")
    public ClientResponse update(@PathVariable Long id, @RequestBody @Valid ClientPutRequest request){
        return restMapper.toResponse(servicePort.update(id,restMapper.toDomainPut(request)));
    }

    @DeleteMapping("/v1/api/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        servicePort.deleteById(id);
        return ResponseEntity.ok("Client with ID: "+id+ "deleted succesfully.");
    }
 }
