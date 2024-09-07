package com.adalbertosn.mapperpoc.api.usecase;

import com.adalbertosn.mapperpoc.api.model.input.CommandInput;
import com.adalbertosn.mapperpoc.api.model.input.RequestInput;
import com.adalbertosn.mapperpoc.api.provider.transunion.ProviderOperation;
import com.adalbertosn.mapperpoc.api.provider.transunion.ProviderOperationExecuteMechanismTransUnionService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

@Slf4j
@Getter
@RequiredArgsConstructor
public class MechanismUseCase{
    private final ProviderOperation providerOperation;
    //@Autowired
    //ProviderOperationExecuteMechanismTransUnionService ProviderOperationExecuteMechanismTransUnionService;

    public Mono<CommandInput> businessProcess(CommandInput command) {
        //log.info("EXECUTE SERVICE: {}", providerOperationsService.getClass().getSimpleName());
        log.info("EXECUTE SERVICE: {}", providerOperation.getClass().getSimpleName());
        //return providerOperation.sendRequest(command);
        return providerOperation.sendRequest(command)
                .map(result->{
                    command.setPayload(result);
                    return command;
                });
    }

    /*
    public Mono<CommandInput> businessProcess(CommandInput command) {
        //log.info("EXECUTE SERVICE: {}", providerOperationsService.getClass().getSimpleName());
        log.info("EXECUTE SERVICE: {}", nameProvider);
        if(this.nameProvider == "TU"){
            // llamar al provider para consumir el servicio externo de TU, mapear resultado retornado por TU con
            // la estructura base definida para cuesionario y retornarla;
            // return providerOperationsService.sendRequest(command);
            return providerOperationExecuteMechanismTransUnion(command)
                    .map(result->{
                        command.setPayload(result);
                        return command;
                    });
        }

        if(this.nameProvider == "EM"){
            // llamar al provider para consumir el servicio externo de TU, mapear resultado retornado por TU con
            // la estructura base definida para cuesionario y retornarla;
            // return providerOperationsService.sendRequest(command);
            //providerOperationExecuteMechanismEvidentMaster(command);
            command.getPayload().setExecuteData("{Estructura base para Cuestionario}");
            return Mono.just(command);
        }
        return Mono.empty();
    }*/
}
