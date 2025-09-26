package sena.facturacion.infrastructure.adapters.input.rest.model.request.Client;

import lombok.*;

@Builder @Getter
@Setter @AllArgsConstructor @NoArgsConstructor
public class ClientSearchRequest {

    private Long id;
    private String name;
    private String address;
    private String contact;
    private Boolean active;
}
