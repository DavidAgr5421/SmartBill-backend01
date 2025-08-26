package sena.facturacion.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Client {

    private Long id;
    private String name; // SISAS
    private String address; // SISAS
    private String contact; // SISAS
    private LocalDateTime creationDate;
}
