package com.adalbertosn.mapperpoc.api.provider.transunion;

import com.adalbertosn.mapperpoc.api.model.input.CommandInput;
import com.adalbertosn.mapperpoc.api.model.input.RequestInput;
import com.adalbertosn.mapperpoc.api.provider.transunion.mapper.TransUnionMapper;
import com.adalbertosn.mapperpoc.api.provider.transunion.model.TransUnionResponse;
import com.adalbertosn.mapperpoc.api.provider.transunion.model.input.TransUnionInput;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor()
public class ProviderOperationExecuteMechanismTransUnionService implements ProviderOperation{
    private final RestTemplate restTemplate;
    private final String url;
    @Autowired
    TransUnionMapper transUnionMapper;

    @Override
    public Mono<RequestInput> sendRequest(CommandInput command)  {
        Mono<TransUnionResponse> transUnionResponse = restRequest(command);
        return transUnionResponse
                        .switchIfEmpty(Mono.error(new Exception("Error")))
                .doOnError(e -> {
                    log.info("Error:"+e.getMessage());
                }).map(result -> {
                    command.getPayload().setExecuteData(transUnionMapper.outSolicitudCuestionaro(result));
                    return command.getPayload();
                });
    }

    public Mono<TransUnionResponse> restRequest(CommandInput command) {
        Mono<TransUnionInput> transUnionInput =
                transUnionMapper.inputSolicitudCuestionaro(command.getPayload());
        log.info("Input payload TU solicitud de cuestionario:");
        // llamar al servicio de TU y obtener resultado
        log.info("llamando al servicio de TU con la URL {}", url);
        log.info(restTemplate.toString());
        String responseTUJsonString = "{\n" +
                "  \"id\": \"2366626\",\n" +
                "  \"registro\": \"2366626\",\n" +
                "  \"preguntas\": {\n" +
                "    \"pregunta\": [\n" +
                "      {\n" +
                "        \"id\": \"4a6733a5-9099-490a-84dd-36a7e05504fa\",\n" +
                "        \"texto\": \"¿Usted canceló o saldó un producto o servicio en los últimos seis meses con ALMACEN RIFICAR?\",\n" +
                "        \"orden\": 1,\n" +
                "        \"identificadordepregunta\": 91,\n" +
                "        \"opcionesderespuesta\": {\n" +
                "          \"opcion\": [\n" +
                "            {\n" +
                "              \"id\": \"0\",\n" +
                "              \"texto\": \"NO\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"1\",\n" +
                "              \"texto\": \"SI\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"209a69db-e28c-4796-aa3f-155f3ac317db\",\n" +
                "        \"texto\": \"¿Usted fue beneficiario del fondo de reserva (FRECH) para la adquisición de vivienda que otorgó el Gobierno?\",\n" +
                "        \"orden\": 2,\n" +
                "        \"identificadordepregunta\": 46,\n" +
                "        \"opcionesderespuesta\": {\n" +
                "          \"opcion\": [\n" +
                "            {\n" +
                "              \"id\": \"0\",\n" +
                "              \"texto\": \"NO\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"1\",\n" +
                "              \"texto\": \"SI\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"4ee18662-f230-4a7c-bd15-65eb57b75f54\",\n" +
                "        \"texto\": \"¿Cuál es la fecha de expedición de su documento de identidad?\",\n" +
                "        \"orden\": 3,\n" +
                "        \"identificadordepregunta\": 2,\n" +
                "        \"opcionesderespuesta\": {\n" +
                "          \"opcion\": [\n" +
                "            {\n" +
                "              \"id\": \"0\",\n" +
                "              \"texto\": \"07/09/1989\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"1\",\n" +
                "              \"texto\": \"11/12/1989\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"2\",\n" +
                "              \"texto\": \"NINGUNA DE LAS ANTERIORES\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"ad6d8127-c838-4dd5-a892-6a03e4c582f2\",\n" +
                "        \"texto\": \"¿Con qué entidad adquirió una tarjeta de crédito en los últimos seis meses?\",\n" +
                "        \"orden\": 4,\n" +
                "        \"identificadordepregunta\": 75,\n" +
                "        \"opcionesderespuesta\": {\n" +
                "          \"opcion\": [\n" +
                "            {\n" +
                "              \"id\": \"0\",\n" +
                "              \"texto\": \"BANAGRARIO\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"1\",\n" +
                "              \"texto\": \"CORFES\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"2\",\n" +
                "              \"texto\": \"COLTEFINANCIERA\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"3\",\n" +
                "              \"texto\": \"Ninguna de las anteriores\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        //JsonObject responseTUObject = new Gson().fromJson(responseTUJsonString, JsonObject.class);
        //JsonObject responseTUObject = JsonParser.parseString(responseTUJsonString).getAsJsonObject();
        JSONObject responseTUObject = new JSONObject(responseTUJsonString);
        return Mono.just(
                TransUnionResponse
                        .builder()
                        .status("success")
                        .responseInfo("responseInfo")
                        .fields(responseTUObject.toMap())
                        .build());
    }
}
