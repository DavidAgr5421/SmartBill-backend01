package sena.facturacion.infrastructure.adapters.input.rest.model.request.Client;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientPutRequest {

    private String name;
    private String email;
    private String address;
    private String contact;
    private Boolean active;
}
