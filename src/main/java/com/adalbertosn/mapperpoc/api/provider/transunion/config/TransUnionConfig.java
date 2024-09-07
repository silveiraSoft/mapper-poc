package com.adalbertosn.mapperpoc.api.provider.transunion.config;

import com.adalbertosn.mapperpoc.api.provider.model.CuestionarioExecuteModel;
import com.adalbertosn.mapperpoc.api.provider.transunion.ProviderOperationExecuteMechanismTransUnionService;
import com.adalbertosn.mapperpoc.api.provider.transunion.model.TransUnionResponse;
import com.adalbertosn.mapperpoc.api.usecase.MechanismExecuteUseCase;
import com.adalbertosn.mapperpoc.api.usecase.MechanismUseCase;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TransUnionConfig {
    @Value("${transunion.execute.url}")
    private String url;

    @Bean("restTemplateTransUnion")
    RestTemplate restTemplateTransUnion() {
        return new RestTemplate();
    }
    @Bean("providerTU")
    ProviderOperationExecuteMechanismTransUnionService providerOperationExecuteMechanismTransUnionService(
            @Qualifier("restTemplateTransUnion")RestTemplate restTemplateTransUnion
            ){
        return new ProviderOperationExecuteMechanismTransUnionService(restTemplateTransUnion, url);
    }

    @Bean("mechanismTransUnionUseCase")
    MechanismUseCase mechanismTransUnionUseCase(@Qualifier("providerTU") ProviderOperationExecuteMechanismTransUnionService providerOperationExecuteMechanismTransUnionService) {
        return new MechanismUseCase(providerOperationExecuteMechanismTransUnionService);
    }

    @Bean("modelMapperTU")
    ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
        modelMapper.createTypeMap(TransUnionResponse.class, CuestionarioExecuteModel.class)
                .addMapping(TransUnionResponse::getFields, CuestionarioExecuteModel::setCuestionario);
        return modelMapper;
        // return new ModelMapper();
    }
}
