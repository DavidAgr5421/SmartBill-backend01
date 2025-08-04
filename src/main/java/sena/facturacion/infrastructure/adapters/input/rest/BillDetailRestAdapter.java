package sena.facturacion.infrastructure.adapters.input.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sena.facturacion.application.ports.input.BillDetailServicePort;
import sena.facturacion.infrastructure.adapters.input.rest.mapper.BillDetailRestMapper;
import sena.facturacion.infrastructure.adapters.input.rest.model.response.BillDetailResponse;

import java.util.List;

@RestController
@RequestMapping("/bills/detail")
@RequiredArgsConstructor
public class BillDetailRestAdapter {

    private final BillDetailServicePort servicePort;
    private final BillDetailRestMapper restMapper;

    @GetMapping("/{id}")
    public BillDetailResponse findById(@PathVariable Long id){
        return restMapper.toDetailResponse(servicePort.findById(id));
    }

    @GetMapping
    public List<BillDetailResponse> findAll(){
        return  restMapper.toDetailResponseList(servicePort.findAll());
    }

}
