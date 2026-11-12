package com.api.rest.service.exception;

public class DuplicateProductException extends RuntimeException {

    public DuplicateProductException(String message) {
        super(message, null, false, false);
    }
}
