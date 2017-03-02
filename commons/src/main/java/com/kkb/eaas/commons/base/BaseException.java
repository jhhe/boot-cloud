package com.kkb.eaas.commons.base;

import com.kkb.eaas.commons.objects.ErrorObject;

/**
 * Created by lixzh on 1/17/17.
 */
public class BaseException extends Exception {
    private static final long serialVersionUID = -6336125614015879324L;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(ErrorObject errorCode) {
        super(errorCode.getMessage());
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
