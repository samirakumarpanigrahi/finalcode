package com.mindtree.ShoppingCart.exception;

public class NoBooksAvailableException extends DaoException {
    public NoBooksAvailableException() {
    }

    public NoBooksAvailableException(String message) {
        super(message);
    }

    public NoBooksAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoBooksAvailableException(Throwable cause) {
        super(cause);
    }

    public NoBooksAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
