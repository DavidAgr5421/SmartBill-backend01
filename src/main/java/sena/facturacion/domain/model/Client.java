package sena.facturacion.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Client {
    private Long id;
    private String name;
    private String address;
    private String contact;
    private LocalDateTime creationDate;
}
