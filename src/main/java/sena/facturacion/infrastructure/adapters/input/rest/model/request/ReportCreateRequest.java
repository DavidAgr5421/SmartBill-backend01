package sena.facturacion.infrastructure.adapters.input.rest.model.request;

import lombok.*;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ReportCreateRequest {

    private Long userId;
    private String observation;

}
