package com.kkb.eaas.commons.exceptions;

import com.kkb.eaas.commons.base.BaseException;
import com.kkb.eaas.commons.objects.ErrorObject;

/**
 * Created by lixzh on 1/17/17.
 */
public class ServiceException extends BaseException {
    private static final long serialVersionUID = -6336125614015879323L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(ErrorObject errorCode) {
        super(errorCode.getMessage());
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
