package com.adalbertosn.mapperpoc.api.exceptionhandler;

import lombok.Getter;
import lombok.ToString;

import java.io.IOException;

@Getter
@ToString
public class BaseTalosException extends IOException {
    private final Integer code;
    private final String identification;
    private final String message;

    public BaseTalosException(final String message) {
        this(message, null);
    }

    public BaseTalosException(ErrorCodes errorCodes){
        this(errorCodes.getDescription(), errorCodes.getCode(), errorCodes.name());
    }

    public BaseTalosException(ErrorCodes errorCodes, Throwable e){
        this(errorCodes.getDescription(), errorCodes.getCode(), errorCodes.name(), e);
    }

    public BaseTalosException(ErrorCodes errorCodes, String additionalErrorMessage){
        this(errorCodes.getDescription() + " (" + additionalErrorMessage + ")", errorCodes.getCode(), errorCodes.name());
    }

    public BaseTalosException(final String message, final Integer code) {
        this(message, code, null);
    }

    public BaseTalosException(final String message, final Integer code, final String identification) {
        this(message, code, identification, null);
    }

    public BaseTalosException(final String message, final Integer code, final String identification, final Throwable throwable) {
        super(message, throwable);
        this.message = message;
        this.code = code;
        this.identification = identification;
    }
}
