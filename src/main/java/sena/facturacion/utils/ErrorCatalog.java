package sena.facturacion.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

    //User Errors Catalog
    USER_NOT_FOUND("ERROR_USER_001","User not found."),
    INVALID_USER("ERROR_USER_002","Invalid user parameters."),
    GENERIC_ERROR("ERROR_GEN_001","An unexpected error ocurred."),

    //User Rol Errors Catalog
    ROL_NOT_FOUND("ERROR_ROL_001","Rol not found."),
    INVALID_ROL("ERROR_ROL_002","Invalid rol parameters.");


    private final String code;
    private final String message;

    ErrorCatalog(String code, String message){
        this.code = code;
        this.message = message;
    }

}
