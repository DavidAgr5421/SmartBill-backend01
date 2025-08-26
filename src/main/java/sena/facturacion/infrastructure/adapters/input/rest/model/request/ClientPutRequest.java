package sena.facturacion.infrastructure.adapters.input.rest.model.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientPutRequest {

    private String name;
    private String address;
    private String contact;
}
