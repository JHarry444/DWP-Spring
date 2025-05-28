package com.qa.demo.exceptions;

public class ParkNotFoundException extends RuntimeException{

    public ParkNotFoundException() {
    }

    public ParkNotFoundException(String message) {
        super(message);
    }

    public ParkNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkNotFoundException(Throwable cause) {
        super(cause);
    }

    public ParkNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
