package com.adalbertosn.mapperpoc.api.provider.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

//@Builder
@Getter
@Setter
public class CuestionarioExecuteModel {
    @JsonProperty("Cuestionario")
    private Map<String,Object> cuestionario;
}
