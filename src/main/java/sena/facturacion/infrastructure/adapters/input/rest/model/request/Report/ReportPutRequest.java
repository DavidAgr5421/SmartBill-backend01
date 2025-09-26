package sena.facturacion.infrastructure.adapters.input.rest.model.request.Report;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
public class ReportPutRequest {
    private String observation;
}
