package sena.facturacion.infrastructure.adapters.input.rest.model.response.Client;

import lombok.*;

import java.time.LocalDateTime;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ClientResponse {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String contact;
    private LocalDateTime creationDate;
    private Boolean active;
}
