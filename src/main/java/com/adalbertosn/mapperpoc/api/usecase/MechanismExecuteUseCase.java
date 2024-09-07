package com.adalbertosn.mapperpoc.api.usecase;

import com.adalbertosn.mapperpoc.api.exceptionhandler.BusinessException;
import com.adalbertosn.mapperpoc.api.exceptionhandler.ErrorCodes;
import com.adalbertosn.mapperpoc.api.exceptionhandler.MechanismNotFoundException;
import com.adalbertosn.mapperpoc.api.model.Step;
import com.adalbertosn.mapperpoc.api.model.input.CommandInput;
import com.adalbertosn.mapperpoc.api.model.input.RequestInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
public class MechanismExecuteUseCase {
    private final MechanismUseCase mechanismTransUnionUseCase;
    private final MechanismUseCase mechanismEvidentMasterUseCase;

    public MechanismExecuteUseCase(
            MechanismUseCase mechanismTransUnionUseCase,
            MechanismUseCase mechanismEvidentMasterUseCase
    ) {
        this.mechanismTransUnionUseCase = mechanismTransUnionUseCase;
        this.mechanismEvidentMasterUseCase = mechanismEvidentMasterUseCase;
    }

    private CommandInput setStepInitExecuted(CommandInput command){
        command.getPayload().setStep(Step.INIT_EXECUTED);
        return command;
    }

    public Mono<RequestInput> businessProcess(Mono<CommandInput> command) {
        return command
                .flatMap(c -> {
                    String mechanism = Optional.ofNullable(c.getPayload().getMechanismExecute())
                            //.map(Object::getClass)
                            //.map(Class::getSimpleName)
                            .orElse("");
                    //if (mechanism.equals(MechanismEvident.class.getSimpleName()) ){
                    if (mechanism.equals("TU") ){
                        //return mechanismTUseCase.process(c).map(this::setStepInitExecuted);
                            return mechanismTransUnionUseCase.businessProcess(c).map(this::setStepInitExecuted);
                    }
                    else if (mechanism.equals("EM")){
                        //return mechanismEvidentMasterUseCase.process(c).map(this::setStepInitExecuted);
                            return mechanismEvidentMasterUseCase.businessProcess(c).map(this::setStepInitExecuted);

                    } else {
                        return Mono.error(
                                //new Exception("Mecanismo no econtrado")
                                new BusinessException(ErrorCodes.MECHANISM_NOT_FOUND)
                        );
                    }
                    /*
                    else if (mechanism.equals(MechanismOTP.class.getSimpleName()) ){
                        return mechanismOTPUseCase.process(c).map(this::setStepInitExecuted);
                    }  else if (mechanism.equals(MechanismIdentityTest.class.getSimpleName()) ){
                        return mechanismIdentityTestUseCase.process(c).map(this::setStepInitExecuted);
                    } else if (mechanism.equals(MechanismTransUnion.class.getSimpleName()) ){
                        return mechanismTransUnionUseCase.process(c).map(this::setStepInitExecuted);
                    } else if (mechanism.equals(MechanismTestExtend.class.getSimpleName()) ){
                        return mechanismTestExtendUseCase.process(c).map(this::setStepInitExecuted);
                    } else if (mechanism.equals(MechanismVoiceBiometrics.class.getSimpleName()) ){
                        return mechanismVoiceBiometricsUseCase.process(c).map(this::setStepInitExecuted);
                    }else {
                        c.getPayload().setStep(Step.VAL_OK);
                        return Mono.just(c);
                    }*/
                })
                .doOnError(e-> {
                    log.info("Error"+e.getMessage());
                })
                .map(c1 -> c1.getPayload());
    }
}
