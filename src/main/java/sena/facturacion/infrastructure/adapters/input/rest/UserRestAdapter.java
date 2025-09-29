package sena.facturacion.infrastructure.adapters.input.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.facturacion.application.ports.input.UserServicePort;
import sena.facturacion.infrastructure.adapters.input.rest.mapper.UserRestMapper;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.UserCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.UserPutRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.UserSearchRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.User.UserResponse;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestAdapter{

    private final UserServicePort servicePort;
    private final UserRestMapper restMapper;

    @GetMapping("/v1/api")
    public List<UserResponse> findAll(){
        return restMapper.toUserResponseList(servicePort.findAll());
    }

    @GetMapping("/v1/api/{id}")
    public UserResponse findById(@PathVariable Long id){
        return restMapper.toUserResponse(servicePort.findById(id));
    }

    @GetMapping("/v1/api/rol/{id}")
    public List<UserResponse> findByRolId(@PathVariable Long id){
        return restMapper.toUserResponseList(servicePort.findByRolId(id));
    }

    @PostMapping("/v1/api")
    public Page<UserResponse> search(Pageable pageable, @RequestBody @Valid UserSearchRequest request){
        System.out.println("PROBANDO REQUEST: "+request);
        return restMapper.toUserResponse(servicePort.search(pageable,request));
    }

    @PostMapping("/v1/api/new")
    public ResponseEntity<UserResponse> save(@Valid @RequestBody UserCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toUserResponse(servicePort.save(restMapper.toUser(request))));
    }

    @PutMapping("v1/api/{id}")
    public UserResponse update(@PathVariable Long id, @Valid @RequestBody UserPutRequest request){
        return restMapper.toUserResponse(servicePort.update(id, restMapper.toUser(request)));
    }

    @DeleteMapping("/v1/api/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        servicePort.deleteById(id);
        return ResponseEntity.ok("User with ID: "+id+" deleted successfully.");
    }
}
