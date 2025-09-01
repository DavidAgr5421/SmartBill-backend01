package sena.facturacion.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Bill {
    private Long id;

    private User userId;
    private Client clientId; // Esto lo necesitamos en formulario

    private Long total; //Esto se genera solo
    private LocalDateTime creationDate; //Esto se genera solo
    private String paymentMethod; // Lo necesitamos en el form

    public Bill(Long id){
        this.id = id;
    }

}
