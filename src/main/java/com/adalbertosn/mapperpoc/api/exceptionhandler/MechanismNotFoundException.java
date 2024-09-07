package com.adalbertosn.mapperpoc.api.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MechanismNotFoundException extends BaseTalosException{
    private static final long serialVersionUID = 1L;

    public MechanismNotFoundException(String mensagem) {
        super(mensagem);
    }

    public MechanismNotFoundException(ErrorCodes errorCodes) {
        super(errorCodes.getDescription(), errorCodes.getCode(), errorCodes.name());
    }

    public MechanismNotFoundException(ErrorCodes errorCodes, Throwable e) {
        super(errorCodes.getDescription(), errorCodes.getCode(), errorCodes.name(), e);
    }
}
