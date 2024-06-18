package com.dacs.beshop.exceptions;

public class InsufficientQuantityException extends  RuntimeException {
    public InsufficientQuantityException(String message) {
        super(message);
    }
}
