package com.qa.demo.exceptions;

public class TreeNotFoundException extends RuntimeException{

    public TreeNotFoundException() {
    }

    public TreeNotFoundException(String message) {
        super(message);
    }

    public TreeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TreeNotFoundException(Throwable cause) {
        super(cause);
    }

    public TreeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
