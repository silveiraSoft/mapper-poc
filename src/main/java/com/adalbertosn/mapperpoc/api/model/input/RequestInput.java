package com.adalbertosn.mapperpoc.api.model.input;

import com.adalbertosn.mapperpoc.api.model.Step;
import com.adalbertosn.mapperpoc.api.provider.model.CuestionarioExecuteModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;

@Data
@Slf4j
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RequestInput {
    @NotNull
    private String requestId;
    @NotNull
    private String transactionId;
    @NotNull
    private String mechanismExecute;
    @JsonProperty("channel-code")
    @NotNull
    private String channelCode;
    private CuestionarioExecuteModel executeData;
    private String validateData;
    private Step step;
}
