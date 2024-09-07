package com.adalbertosn.mapperpoc.api.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BusinessException extends BaseTalosException{
    private static final long serialVersionUID = 1L;

    public BusinessException(String mensagem) {
        super(mensagem);
    }

    public BusinessException(ErrorCodes errorCodes) {
        super(errorCodes.getDescription(), errorCodes.getCode(), errorCodes.name());
    }

    public BusinessException(ErrorCodes errorCodes, Throwable e) {
        super(errorCodes.getDescription(), errorCodes.getCode(), errorCodes.name(), e);
    }
}
