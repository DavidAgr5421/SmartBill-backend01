package sena.facturacion.infrastructure.adapters.input.rest;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sena.facturacion.domain.exception.*;
import sena.facturacion.domain.exception.Bill.BillDetailNotFoundException;
import sena.facturacion.domain.exception.Bill.BillNotFoundException;
import sena.facturacion.domain.exception.Bill.InvalidBillDetailException;
import sena.facturacion.domain.exception.Bill.InvalidBillException;
import sena.facturacion.domain.exception.Client.ClientAlreadyExistsException;
import sena.facturacion.domain.exception.Client.ClientInactiveException;
import sena.facturacion.domain.exception.Client.ClientNotFoundException;
import sena.facturacion.domain.exception.Client.InvalidClientException;
import sena.facturacion.domain.exception.Product.InvalidProductException;
import sena.facturacion.domain.exception.Product.ProductAlreadyExistsException;
import sena.facturacion.domain.exception.Product.ProductInactiveException;
import sena.facturacion.domain.exception.Product.ProductNotFoundException;
import sena.facturacion.domain.exception.User.*;
import sena.facturacion.utils.ErrorCatalog;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerAdvice {


    // ================= USER =================
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUserNotFoundException(){
        return ErrorResponse.builder()
                .code(ErrorCatalog.USER_NOT_FOUND.getCode())
                .message(ErrorCatalog.USER_NOT_FOUND.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleUserRequestException(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();

        return ErrorResponse.builder()
                .code(ErrorCatalog.INVALID_USER.getCode())
                .message(ErrorCatalog.INVALID_USER.getMessage())
                .details(result.getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timeStamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.CONFLICT) // 409
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ErrorResponse handleUserAlreadyExistsException() {
        return ErrorResponse.builder()
                .code(ErrorCatalog.USER_ALREADY_EXISTS.getCode())
                .message(ErrorCatalog.USER_ALREADY_EXISTS.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    @ExceptionHandler(UserInactiveException.class)
    public ErrorResponse handleUserInactiveException() {
        return ErrorResponse.builder()
                .code(ErrorCatalog.USER_INACTIVE.getCode())
                .message(ErrorCatalog.USER_INACTIVE.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    // ================= ROL =================

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserRolNotFoundException.class)
    public ErrorResponse handleUserRolNotFoundException(){
        return ErrorResponse.builder()
                .code(ErrorCatalog.ROL_NOT_FOUND.getCode())
                .message(ErrorCatalog.ROL_NOT_FOUND.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    @ExceptionHandler(InvalidRolException.class)
    public ErrorResponse handleInvalidRolException() {
        return ErrorResponse.builder()
                .code(ErrorCatalog.INVALID_ROL.getCode())
                .message(ErrorCatalog.INVALID_ROL.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    // ================= PRIVILEGES =================

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RolPrivilegesNotFound.class)
    public ErrorResponse handleRolPrivilegesNotFoundException(){
        return ErrorResponse.builder()
                .code(ErrorCatalog.PRIVILEGES_NOT_FOUND.getCode())
                .message(ErrorCatalog.PRIVILEGES_NOT_FOUND.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    @ExceptionHandler(InvalidPrivilegesException.class)
    public ErrorResponse handleInvalidPrivilegesException() {
        return ErrorResponse.builder()
                .code(ErrorCatalog.INVALID_PRIVILEGES.getCode())
                .message(ErrorCatalog.INVALID_PRIVILEGES.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.CONFLICT) // 409
    @ExceptionHandler(PrivilegesAlreadyExistsException.class)
    public ErrorResponse handlePrivilegesAlreadyExistsException() {
        return ErrorResponse.builder()
                .code(ErrorCatalog.PRIVILEGES_ALREADY_EXISTS.getCode())
                .message(ErrorCatalog.PRIVILEGES_ALREADY_EXISTS.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    // ================= BILL =================
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BillNotFoundException.class)
    public ErrorResponse handleBillNotFoundException(){
        return ErrorResponse.builder()
                .code(ErrorCatalog.BILL_NOT_FOUND.getCode())
                .message(ErrorCatalog.BILL_NOT_FOUND.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    @ExceptionHandler(InvalidBillException.class)
    public ErrorResponse handleInvalidBillException() {
        return ErrorResponse.builder()
                .code(ErrorCatalog.INVALID_BILL.getCode())
                .message(ErrorCatalog.INVALID_BILL.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.NOT_FOUND) // 404
    @ExceptionHandler(BillDetailNotFoundException.class)
    public ErrorResponse handleBillDetailNotFoundException() {
        return ErrorResponse.builder()
                .code(ErrorCatalog.BILL_DETAIL_NOT_FOUND.getCode())
                .message(ErrorCatalog.BILL_DETAIL_NOT_FOUND.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    @ExceptionHandler(InvalidBillDetailException.class)
    public ErrorResponse handleInvalidBillDetailException() {
        return ErrorResponse.builder()
                .code(ErrorCatalog.INVALID_BILL_DETAIL.getCode())
                .message(ErrorCatalog.INVALID_BILL_DETAIL.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }


    // ================= CLIENT =================
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ClientNotFoundException.class)
    public ErrorResponse handleClientNotFoundException(){
        return ErrorResponse.builder()
                .code(ErrorCatalog.CLIENT_NOT_FOUND.getCode())
                .message(ErrorCatalog.CLIENT_NOT_FOUND.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidClientException.class)
    public ErrorResponse handleInvalidClientException(){
        return ErrorResponse.builder()
                .code(ErrorCatalog.INVALID_CLIENT.getCode())
                .message(ErrorCatalog.INVALID_CLIENT.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.CONFLICT) // 409
    @ExceptionHandler(ClientAlreadyExistsException.class)
    public ErrorResponse handleClientAlreadyExistsException() {
        return ErrorResponse.builder()
                .code(ErrorCatalog.CLIENT_ALREADY_EXISTS.getCode())
                .message(ErrorCatalog.CLIENT_ALREADY_EXISTS.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400 or 403 depending on your business logic
    @ExceptionHandler(ClientInactiveException.class)
    public ErrorResponse handleClientInactiveException() {
        return ErrorResponse.builder()
                .code(ErrorCatalog.CLIENT_INACTIVE.getCode())
                .message(ErrorCatalog.CLIENT_INACTIVE.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    // ================= PRODUCT =================
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handleProductNotFoundException(){
        return ErrorResponse.builder()
                .code(ErrorCatalog.PRODUCT_NOT_FOUND.getCode())
                .message(ErrorCatalog.PRODUCT_NOT_FOUND.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidProductException.class)
    public ErrorResponse handleInvalidProductException(){
        return ErrorResponse.builder()
                .code(ErrorCatalog.INVALID_PRODUCT.getCode())
                .message(ErrorCatalog.INVALID_PRODUCT.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.CONFLICT) // 409
    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ErrorResponse handleProductAlreadyExistsException() {
        return ErrorResponse.builder()
                .code(ErrorCatalog.PRODUCT_ALREADY_EXISTS.getCode())
                .message(ErrorCatalog.PRODUCT_ALREADY_EXISTS.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400 or 403 depending on business rules
    @ExceptionHandler(ProductInactiveException.class)
    public ErrorResponse handleProductInactiveException() {
        return ErrorResponse.builder()
                .code(ErrorCatalog.PRODUCT_INACTIVE.getCode())
                .message(ErrorCatalog.PRODUCT_INACTIVE.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    // ================= GENERIC =================
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGenericError(Exception exception){
        return ErrorResponse.builder()
                .code(ErrorCatalog.GENERIC_ERROR.getCode())
                .message(ErrorCatalog.GENERIC_ERROR.getMessage())
                .details(Collections.singletonList(exception.getMessage()))
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
