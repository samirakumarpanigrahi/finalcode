package com.mindtree.ShoppingCart.exception;

import java.util.function.Supplier;

public class UserNotFindException extends DaoException {
    public UserNotFindException() {
    }

    public UserNotFindException(String message) {
        super(message);
    }

    public UserNotFindException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFindException(Throwable cause) {
        super(cause);
    }

    public UserNotFindException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
