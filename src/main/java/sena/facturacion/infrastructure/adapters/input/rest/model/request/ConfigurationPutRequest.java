package sena.facturacion.infrastructure.adapters.input.rest.model.request;

import lombok.*;

import java.time.LocalDateTime;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ConfigurationPutRequest {

    private String configName;
    private String contact;
    private String nit;
    private String footer;

    private Long paperWidth;
    private Long fontSize;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String logoType;
    private String qrType;
}
