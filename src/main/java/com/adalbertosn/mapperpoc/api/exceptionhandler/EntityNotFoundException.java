package com.adalbertosn.mapperpoc.api.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends BaseTalosException{
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(String mensagem) {
        super(mensagem);
    }

    public EntityNotFoundException(ErrorCodes errorCodes) {
        super(errorCodes.getDescription(), errorCodes.getCode(), errorCodes.name());
    }

    public EntityNotFoundException(ErrorCodes errorCodes, Throwable e) {
        super(errorCodes.getDescription(), errorCodes.getCode(), errorCodes.name(), e);
    }

}
