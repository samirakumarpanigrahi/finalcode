package com.mindtree.ShoppingCart.exception;

public class NoApparalAvailabeException extends DaoException {

    public NoApparalAvailabeException() {
    }

    public NoApparalAvailabeException(String message) {
        super(message);
    }

    public NoApparalAvailabeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoApparalAvailabeException(Throwable cause) {
        super(cause);
    }

    public NoApparalAvailabeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
