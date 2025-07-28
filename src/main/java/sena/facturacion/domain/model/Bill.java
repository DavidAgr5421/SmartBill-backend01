package sena.facturacion.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Bill {
    private Long id;

    private User userId;
    private Client clientId;

    private Long total;
    private LocalDateTime creationDate;
    private String paymentMethod;
}
