package com.adalbertosn.mapperpoc.api.provider.transunion.mapper;

import com.adalbertosn.mapperpoc.api.model.input.RequestInput;
import com.adalbertosn.mapperpoc.api.provider.model.CuestionarioExecuteModel;
import com.adalbertosn.mapperpoc.api.provider.transunion.model.TransUnionResponse;
import com.adalbertosn.mapperpoc.api.provider.transunion.model.input.TransUnionInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class TransUnionMapper {
    @Autowired
    @Qualifier("modelMapperTU")
    ModelMapper modelMapper;

    public Mono<TransUnionInput> inputSolicitudCuestionaro(RequestInput payload) {
        log.info("Datos a ser mapeador para crear el payload de la solicitud de cuestionario de TU:" + payload);
        String jsonInputTU = "{\n" +
                "  \"celula\": \"12132133\",\n" +
                "  \"celular\": \"cel1\"\n" +
                "}";
        try {
            log.info("Payload de TU resultado del mapeo:" + jsonInputTU);
            ObjectMapper mapper = new ObjectMapper();
            return Mono.just(mapper.readValue(jsonInputTU, TransUnionInput.class));
        } catch(JsonProcessingException e){
            return Mono.error(new Exception("Error en el Mapper de Solicitud de TU"));
        }
    }

    public CuestionarioExecuteModel outSolicitudCuestionaro(TransUnionResponse responseTU) {
        log.info("Datos a ser mapeador para crear el payload de la solicitud de cuestionario de TU:" + responseTU);
        return modelMapper.map(responseTU, CuestionarioExecuteModel.class);
        //return CuestionarioExecuteModel.builder().cuestionario("Datos de cuestionario de TU mapeado a la estructura genérica de cuestionario.").build();
        //JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
        //JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        /*
        String json = "{\"dato\":\"Datos de cuestionario de TU mapeado a la estructura generica de cuestionario\"}";
        JSONObject jsonObject = new JSONObject(json);
        return CuestionarioExecuteModel.builder().cuestionario(jsonObject.toMap()).build();
         */
    }
}
