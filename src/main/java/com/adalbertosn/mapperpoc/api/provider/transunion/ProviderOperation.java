package com.adalbertosn.mapperpoc.api.provider.transunion;

import com.adalbertosn.mapperpoc.api.model.input.CommandInput;
import com.adalbertosn.mapperpoc.api.model.input.RequestInput;
import reactor.core.publisher.Mono;

public interface ProviderOperation {
    Mono<RequestInput> sendRequest(CommandInput command);
}
