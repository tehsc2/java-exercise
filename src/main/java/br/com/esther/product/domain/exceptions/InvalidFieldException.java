package br.com.esther.product.domain.exceptions;

public class InvalidFieldException extends RuntimeException {
    public InvalidFieldException(String message){
        super(message);
    }
}
