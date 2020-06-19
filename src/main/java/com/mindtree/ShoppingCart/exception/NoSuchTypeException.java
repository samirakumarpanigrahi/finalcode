package com.mindtree.ShoppingCart.exception;

public class NoSuchTypeException extends ServiceException {

    public NoSuchTypeException() {
    }

    public NoSuchTypeException(String message) {
        super(message);
    }

    public NoSuchTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchTypeException(Throwable cause) {
        super(cause);
    }

    public NoSuchTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
