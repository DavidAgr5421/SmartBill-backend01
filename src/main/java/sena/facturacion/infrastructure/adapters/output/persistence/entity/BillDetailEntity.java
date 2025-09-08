package sena.facturacion.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigInteger;

@Entity
@Table(name = "bill_detail")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class BillDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_bill_id")
    private BillEntity billId;
    @ManyToOne
    @JoinColumn(name = "fk_product_id")
    private ProductEntity productId;
    private BigInteger amount;
    private Long subTotal;
    private String observation;
}
