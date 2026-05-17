package com.jusconnect.shared.kernel.exceptions;

public class NotFoundException
        extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}