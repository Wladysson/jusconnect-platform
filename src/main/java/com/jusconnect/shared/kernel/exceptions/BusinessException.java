package com.jusconnect.shared.kernel.exceptions;

public class BusinessException
        extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}