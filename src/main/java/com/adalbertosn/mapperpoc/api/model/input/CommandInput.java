package com.adalbertosn.mapperpoc.api.model.input;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CommandInput {
     private String id;
     private String idTrazabilidad;
     private RequestInput payload;
}
