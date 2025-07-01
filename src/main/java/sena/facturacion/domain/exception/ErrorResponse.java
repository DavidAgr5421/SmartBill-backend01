package sena.facturacion.domain.exception;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
public class ErrorResponse {

    private String code;
    private String message;
    private List<String> details;
    private LocalDateTime timeStamp;



}
