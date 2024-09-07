package com.adalbertosn.mapperpoc.api.controller;

import com.adalbertosn.mapperpoc.api.model.input.CommandInput;
import com.adalbertosn.mapperpoc.api.model.input.RequestInput;
import com.adalbertosn.mapperpoc.api.usecase.MechanismExecuteUseCase;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/mechanism")
public class MechanismController {
    @Autowired
    private MechanismExecuteUseCase mechanismExecuteUseCase;

    @PostMapping(value = "/execute2", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    //@PostMapping(value = "/execute")
    public Mono<Map<String,Object>> execute2(@RequestBody @Valid CommandInput command) {
        //return mechanismExecuteUseCase.businessProcess(command).onErrorResume(Mono::error);
        //return Mono.just(command.getPayload());
        //JsonObject jsonObject = JsonParser.parseString("{'id':1}").getAsJsonObject();
        JSONObject jsonObject = new JSONObject("{'id':1}");
        return Mono.just(jsonObject.toMap());
    }
    @PostMapping(value = "/execute", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<RequestInput> execute(@RequestBody @Valid Mono<CommandInput> command) {
        return mechanismExecuteUseCase.businessProcess(command).onErrorResume(Mono::error);
        //return Mono.just(command.getPayload());
    }

    @PostMapping("/execute1")
    public Mono<String> process(@RequestBody String name) {
        return Mono.just("hello " + name);
    }
}
