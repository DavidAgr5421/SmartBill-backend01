package sena.facturacion.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Configuration {
    private Long id;
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
