package com.adalbertosn.mapperpoc.api.model;

public enum Step {
    INIT_REQUEST("init_request"), //inicia el proceso de validacion
    INIT_VALIDATED("init_validated"), //Salio del MS requestValidation
    INIT_COMPLETION("init_completion"), //Salio del MS requestCompletion
    INIT_RULE_SERVICE("init_rule_service"), //Envio al Rule Service
    INIT_EXECUTE("init_execute"), //Sale de MS RuleProcess
    INIT_EXECUTED("init_executed"), //Sale de MS executeMechanism
    INIT_CANCEL("init_cancel"), //Sale de MS executeMechanism

    VAL_CHECKED("val_checked"), //Sale del MS Chequear Validación
    VAL_VALIDATED("val_validated"), //Sale del MS validate
    VAL_CANCEL("val_cancel"), //Sale del MS validateMechanism (no validado)
    VAL_OK("val_ok"), //Sale del MS validateMechanism (valido)

    //Steps Micro identidades

    INIT_REQUEST_IDENTITIES("init_request_identities"), //inicia el proceso de confirmación de identidades
    ;

    public final String label;

    private Step(String label) {
        this.label = label;
    }
}
