package sena.facturacion.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

    //User Errors Catalog
    USER_NOT_FOUND("ERROR_USER_001","User not found."),
    INVALID_USER("ERROR_USER_002","Invalid user parameters."),
    USER_ALREADY_EXISTS("ERROR_USER_003","The User you are saving already exists."),
    USER_INACTIVE("ERROR_USER_004","The User is inactive"),
    GENERIC_ERROR("ERROR_GEN_001","An unexpected error ocurred."),

    //User Rol Errors Catalog
    ROL_NOT_FOUND("ERROR_ROL_001","Rol not found."),
    INVALID_ROL("ERROR_ROL_002","Invalid rol parameters."),

    //Rol privileges Errors Catalog
    PRIVILEGES_NOT_FOUND("ERROR_PRIVILEGES_001","Rol Privileges not found."),
    INVALID_PRIVILEGES("ERROR_PRIVILEGES_002","Invalid Rol Privileges parameters."),
    PRIVILEGES_ALREADY_EXISTS("ERROR_PRIVILEGES_003","Rol Privileges already exist."),

    //Bill Errors Catalog
    BILL_NOT_FOUND("ERROR_BILL_001","Bill not found"),
    INVALID_BILL("ERROR_BILL_002","Invalid bill parameters."),

    // Bill Details Errors
    BILL_DETAIL_NOT_FOUND("ERROR_BILL_DETAIL_001","Bill detail not found."),
    INVALID_BILL_DETAIL("ERROR_BILL_DETAIL_002","Invalid bill detail parameters."),

    //Client Errors
    CLIENT_NOT_FOUND("ERROR_CLIENT_001","Client not found."),
    INVALID_CLIENT("ERROR_CLIENT_002","Invalid client parameters."),
    CLIENT_ALREADY_EXISTS("ERROR_CLIENT_003","Client already exists."),
    CLIENT_INACTIVE("ERROR_CLIENT_004","Client is inactive."),

    // Product Errors
    PRODUCT_NOT_FOUND("ERROR_PRODUCT_001","Product not found."),
    INVALID_PRODUCT("ERROR_PRODUCT_002","Invalid product parameters."),
    PRODUCT_ALREADY_EXISTS("ERROR_PRODUCT_003","Product already exists."),
    PRODUCT_INACTIVE("ERROR_PRODUCT_004","Product is inactive.");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message){
        this.code = code;
        this.message = message;
    }

}
