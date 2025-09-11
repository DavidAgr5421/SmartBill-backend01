package sena.facturacion.infrastructure.adapters.input.rest.model.request;

import lombok.*;

import java.time.LocalDateTime;

@Builder @Getter
@Setter @AllArgsConstructor @NoArgsConstructor
public class ClientSearchRequest {

    private String name;
    private String address;
    private String contact;

}
