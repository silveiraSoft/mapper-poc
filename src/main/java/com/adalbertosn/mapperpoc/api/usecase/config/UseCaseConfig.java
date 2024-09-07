package com.adalbertosn.mapperpoc.api.usecase.config;

import com.adalbertosn.mapperpoc.api.usecase.MechanismExecuteUseCase;
import com.adalbertosn.mapperpoc.api.usecase.MechanismUseCase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    MechanismExecuteUseCase mechanismExecuteUseCase(@Qualifier("mechanismTransUnionUseCase") MechanismUseCase mechanismTransUnionUseCase, @Qualifier("mechanismTransUnionUseCase") MechanismUseCase mechanismEvidentMasterUseCase){
        return new MechanismExecuteUseCase(mechanismTransUnionUseCase, mechanismEvidentMasterUseCase);
    }
}
