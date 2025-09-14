package sena.facturacion.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ConfigurationPutRequest {

    @NotBlank(message = "The Configuration Name cannot be blank!")
    private String configName;
    @NotBlank(message = "The Contact cannot be blank!")
    private String contact;
    private String nit;
    private String footer;

    private Long paperWidth;
    private Long fontSize;

    private String logoType;
    private String qrType;
}
