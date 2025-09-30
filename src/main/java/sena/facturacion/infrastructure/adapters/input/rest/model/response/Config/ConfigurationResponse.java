package sena.facturacion.infrastructure.adapters.input.rest.model.response.Config;

import lombok.*;

import java.time.LocalDateTime;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ConfigurationResponse {

    private Long id;
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
