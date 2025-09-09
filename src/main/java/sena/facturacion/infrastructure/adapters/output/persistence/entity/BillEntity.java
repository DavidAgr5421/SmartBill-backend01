package sena.facturacion.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bill")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class BillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "fk_client_id")
    private ClientEntity clientId;

    private Long total;
    private LocalDateTime creationDate;
    private String paymentMethod;

    @OneToMany(mappedBy = "billId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BillDetailEntity> billDetails;
}
