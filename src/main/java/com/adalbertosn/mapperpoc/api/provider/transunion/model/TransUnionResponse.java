package com.adalbertosn.mapperpoc.api.provider.transunion.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import java.util.Map;

@Builder
@Getter
@Setter
public class TransUnionResponse {
    @JsonProperty("Status")
    private String status;
    @JsonProperty("ResponseInfo")
    private String responseInfo;
    @JsonProperty("Fields")
    private Map<String, Object> fields;
}
