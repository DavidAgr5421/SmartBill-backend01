package sena.facturacion.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "report")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private UserEntity userId;
    private BigDecimal totalSales;
    private BigDecimal monthSales;
    private String observation;
    private List<String> productOnStock;
    private List<String> productOnLowStock;
}
