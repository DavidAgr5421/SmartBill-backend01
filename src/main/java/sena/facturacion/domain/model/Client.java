package sena.facturacion.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Client {

    private Long id;
    private String name; // SISAS
    private String email;
    private String address; // SISAS
    private String contact; // SISAS
    private Boolean active;
    private LocalDateTime creationDate;

    public Client(Long id) {
        this.id = id;
        this.name = null;
        this.address = null;
        this.contact = null;
        this.creationDate = null;
    }
}
