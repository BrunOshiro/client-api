package com.jazztech.STAG2504_ClientApi.infrastructure.exceptions;

public class CPFAlreadyExistException extends Throwable {
    public CPFAlreadyExistException(String message) {
        super(message);
    }
}