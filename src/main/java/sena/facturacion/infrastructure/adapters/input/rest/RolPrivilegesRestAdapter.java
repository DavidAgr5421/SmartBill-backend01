package sena.facturacion.infrastructure.adapters.input.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.facturacion.application.ports.input.RolPrivilegesServicePort;
import sena.facturacion.infrastructure.adapters.input.rest.mapper.RolPrivilegesRestMapper;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.RolPrivilegesCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.RolPrivilegesPutRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.User.RolPrivilegesResponse;

@RestController
@RequestMapping("/users-rol/{id}/privileges")
@RequiredArgsConstructor
public class RolPrivilegesRestAdapter {

    private final RolPrivilegesServicePort servicePort;
    private final RolPrivilegesRestMapper restMapper;


    @GetMapping
    public RolPrivilegesResponse findById(@PathVariable Long id){
        return restMapper.toRolPrivilegesResponse(servicePort.findById(id));
    }

    @PostMapping
    public ResponseEntity<RolPrivilegesResponse> save(@Valid @RequestBody RolPrivilegesCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(restMapper.toRolPrivilegesResponse(servicePort.save(restMapper.toRolPrivileges(request))));
    }

    @PutMapping
    public RolPrivilegesResponse update(@PathVariable Long id, @Valid @RequestBody RolPrivilegesPutRequest request){
        return restMapper.toRolPrivilegesResponse(servicePort.update(id,restMapper.toRolPrivilegesPut(request)));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@PathVariable Long id){
        servicePort.delete(id);
        return ResponseEntity.ok("Rol Privileges for Rol "+id+" deleted succesfully.");
    }
}


