package com.jusconnect.shared.kernel.exceptions;

public class ValidationException
        extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}