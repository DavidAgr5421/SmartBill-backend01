package sena.facturacion.infrastructure.adapters.input.rest.model.request;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class ProductSearchRequest {

    private String name;
    private String referenceNo;
    private BigInteger startAmount;
    private BigInteger endAmount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
