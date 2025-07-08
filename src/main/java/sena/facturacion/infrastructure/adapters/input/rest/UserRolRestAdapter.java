package sena.facturacion.infrastructure.adapters.input.rest;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.facturacion.application.ports.input.UserRolServicePort;
import sena.facturacion.application.ports.input.UserServicePort;
import sena.facturacion.domain.model.User;
import sena.facturacion.domain.model.UserRol;
import sena.facturacion.infrastructure.adapters.input.rest.mapper.UserRolRestMapper;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.UserRolRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.UserRolResponse;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.UserRolEntity;

import java.util.List;

@RestController
@RequestMapping("/users-rol")
@RequiredArgsConstructor
public class UserRolRestAdapter {

    private final UserRolServicePort servicePort;
    private final UserRolRestMapper restMapper;

    @GetMapping("/v1/api")
    public List<UserRolResponse> findAll(){
        return restMapper.toUserRolResponseList(servicePort.findAll());
    }

    @GetMapping("/v1/api/{id}")
    public UserRolResponse findRolById(@PathVariable Long id){
        return restMapper.toUserRolResponse(servicePort.findByRolId(id));
    }

    @PostMapping("/v1/api")
    public ResponseEntity<UserRolResponse> save(@Valid @RequestBody UserRolRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(restMapper.toUserRolResponse(servicePort.save(restMapper.toUserRol(request))));
    }

    @PutMapping("/v1/apí")
    public UserRolResponse update(@PathVariable Long id, @Valid @RequestBody UserRolRequest request){
        return restMapper.toUserRolResponse(servicePort.update(id,restMapper.toUserRol(request)));
    }

    @DeleteMapping("/v1/api/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        servicePort.delete(id);
        return ResponseEntity.ok("User Rol with ID "+id+" deleted succesfully.");
    }

}
