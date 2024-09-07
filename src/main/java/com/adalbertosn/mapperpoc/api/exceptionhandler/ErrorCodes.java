package com.adalbertosn.mapperpoc.api.exceptionhandler;

public enum ErrorCodes {
    MECHANISM_NOT_FOUND(7000, "Mecanismo no encontrado."),

    UNKNOWN_ERROR(1999, "Unknown error."),
    SEND_TO_SNS_ERROR(1900, "Not Data send to SNS"),

    SERVICE_REST_AI_CLIENT_UNKNOWN(5201, "Service AI. Error consuming endpoint. Unknown error."),
    SERVICE_REST_AI_CLIENT_TECHNICAL(5202, "Service AI. Error consuming endpoint. Technical Error."),
    SERVICE_REST_AI_CLIENT_BUSINESS(5203, "Service AI . Error consuming endpoint."),
    SERVICE_REST_AI_NOT_REQUEST_DATA(5204, "Service AI. Not request data."),
    SERVICE_REST_IA_ENROLLMENT(5205, "Service AI. Error enrolling audio."),
    SERVICE_REST_AI_CONSUMING_REST(5206, "Service AI. Error consuming endpoint."),

    VALIDATE_MECHANISM_NOT_VALID(4003, "Mechanism not valid."),

    REST_REQUEST_ENROLLMENT_LIMITS_FAILED_ATTEMPTS_BY_DAY(2222, "Reached the limit of failed attempts on the day."),
    REST_REQUEST_ENROLLMENT_LIMITS_FAILED_ATTEMPTS_BY_MONTH(2223, "Reached the limit of failed attempts in the month."),

    SERVICE_REST_ENROLLMENT_PHRASE_NOT_FOUND(5301, "Service ENROLLMENT. Phrase not found."),
    SERVICE_REST_ENROLLMENT_TRANSACTION_EXPIRED_TIME(5302, "Service ENROLLMENT. Time expired for this transaction."),
    SERVICE_REST_ENROLLMENT_AUDIO(5303, "Service ENROLLMENT. Error enrolling audio."),
    SERVICE_REST_ENROLLMENT_AUDIO_SAVE_IN_BUCKET1(5304, "Service ENROLLMENT. Error saving audio in bucket."),
    SERVICE_REST_ENROLLMENT_UPDATING_RESULT_IA(5305, "Service ENROLLMENT. Error updating in the table history the result of IA."),
    SERVICE_REST_ENROLLMENT_MAX_NUM_ERRORS(5306, "Service ENROLLMENT. Reached the maximum number of attempts."),
    SERVICE_REST_ENROLLMENT_RESET_NUMBERS_ERROS(5307, "Service ENROLLMENT. Error resetting numbers of errors to zero."),


    SERVICE_REST_ENROLLMENT_INVALID_AUDIO_FORMAT(5401, "Service ENROLLMENT. Invalid audio format"),
    SERVICE_REST_ENROLLMENT_COULD_NOT_UPLOAD(5402, "could not upload audio to bucket"),

    SERVICE_REST_ENROLLMENT_STATUS_TRANSACTION_CONSUMING_REST(5501, "Service STATUS_TRANSACTION. Error consuming endpoint."),
    SERVICE_REST_ENROLLMENT_STATUS_TRANSACTION_NOT_FOUND(5502, "Service STATUS_TRANSACTION. Transaction not found."),

    SERVICE_REST_VALIDATE_PHRASE_NOT_FOUND(5601, "Service VALIDATION. Phrase not found."),
    SERVICE_REST_VALIDATE_TRANSACTION_EXPIRED_TIME(5602, "Service VALIDATE. Time expired for this transaction."),

    SERVICE_REST_VALIDATE_AUDIO(5701, "Service VALIDATE. Audio validation error."),
    SERVICE_REST_VALIDATE_AUDIO_SAVE_IN_BUCKET1(5702, "Service VALIDATE. Error saving audio in bucket."),
    SERVICE_REST_VALIDATE_INVALID_AUDIO_FORMAT(5703, "Service VALIDATE. Invalid audio format"),
    SERVICE_REST_VALIDATE_COULD_NOT_UPLOAD(5701, "could not upload audio to bucket"),

    SERVICE_REST_VALIDATE_UPDATE_HISTORY(5801, "Service VALIDATE. Error updating in the table history the result of IA."),

    SERVICE_REST_VALIDATE_STATUS_TRANSACTION_CONSUMING_REST(5901, "Service STATUS_TRANSACTION. Error consuming endpoint."),
    SERVICE_REST_VALIDATE_STATUS_TRANSACTION_NOT_FOUND(5902, "Service STATUS_TRANSACTION. Transaction not found."),

    REST_REQUEST_VALIDATE_LIMITS_FAILED_ATTEMPTS_BY_DAY(6001, "Reached the limit of failed attempts on the day."),
    REST_REQUEST_VALIDATE_LIMITS_FAILED_ATTEMPTS_BY_MONTH(6002, "Reached the limit of failed attempts in the month."),

    SERVICE_REST_IA_VALIDATE(6102, "Service AI. Error validating audio."),
    SERVICE_VALIDATE_IA_PERCENTAGE_VOICE (6103, "Service AI. The user did not pass the percentage level of validation"),
    REQUEST_STATUS_TRANSACTION_NO_DATA(3701, "Request Status transaction . Not data to request service."),

    REQUEST_STATUS_TRANSACTION_REST_CLIENT_BUSINESS(3702, "Request Status transaction. Error consuming endpoint."),

    REQUEST_STATUS_TRANSACTION_REST_CLIENT_TECHNICAL(3703, "Request Status transaction. Error consuming endpoint. Technical Error."),

    REQUEST_STATUS_TRANSACTION_REST_CLIENT_UNKNOWN(3704, "Request Status transaction. Error consuming endpoint. Unknown error."),

    REQUEST_STATUS_TRANSACTION_REST_CONSUMING_REST(3705, "Request Status transaction Error consuming endpoint."),

    REQUEST_STATUS_TRANSACTION_REST_NOT_REQUEST_DATA(3306, "Request Status transaction. Not request data."),

    REQUEST_STATUS_TRANSACTION_CAN_NOT_VALIDATED(3307, "Request Status transaction. The client cannot be validated."),






    ;

    private final int code;
    private final String description;

    private ErrorCodes(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
