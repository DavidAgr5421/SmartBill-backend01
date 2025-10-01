package sena.facturacion.infrastructure.adapters.input.rest;


import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.facturacion.application.ports.input.UserRolServicePort;
import sena.facturacion.domain.model.UserRol;
import sena.facturacion.infrastructure.adapters.input.rest.mapper.UserRolRestMapper;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.UserRolRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.User.UserRolResponse;

import java.util.List;

@RestController
@RequestMapping("/users-rol")
@RequiredArgsConstructor
public class UserRolRestAdapter {

    private final UserRolServicePort servicePort;
    private final UserRolRestMapper restMapper;

//    @PostConstruct
//    public UserRolResponse saveDefault(){
//        return restMapper.toUserRolResponse(servicePort.save(new UserRol("GUEST", null)));
//    }

    @GetMapping("/v1/api")
    public List<UserRolResponse> findAll(){
        return restMapper.toUserRolResponseList(servicePort.findAll());
    }

    @GetMapping("/v1/api/{id}")
    public UserRolResponse findRolById(@PathVariable Long id){
        return restMapper.toUserRolResponse(servicePort.findByRolId(id));
    }

    @GetMapping("/v1/api/by-name")
    public UserRolResponse findRolByRolName(@RequestParam String rolName){
        return  restMapper.toUserRolResponse(servicePort.findByRolName(rolName));
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
