package com.adalbertosn.mapperpoc;

import com.adalbertosn.mapperpoc.api.usecase.MechanismExecuteUseCase;
import com.adalbertosn.mapperpoc.api.usecase.MechanismUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.lang.management.ManagementFactory;
import java.text.NumberFormat;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }/*, scanBasePackages = "com.adalbertosn.mapperpoc"*/)
@EnableWebFlux
@Slf4j
@EnableConfigurationProperties
public class MapperPocApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(MapperPocApplication.class, args);
        ObjectMapper mapper = context.getBean("objectMapper", ObjectMapper.class);
        log.info("Info Bean ObjectMapper " + mapper.toString());
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }

    public static void printInfo() {
        Runtime runtime = Runtime.getRuntime();

        final NumberFormat format = NumberFormat.getInstance();
        final long maxMemory = runtime.maxMemory();
        final long allocatedMemory = runtime.totalMemory();
        final long freeMemory = runtime.freeMemory();
        final long mb = 1024L * 1024L;
        final String mega = " MB";
        log.info("========================== Memory Info ==========================");
        log.info("name = " + ManagementFactory.getRuntimeMXBean().getName());
        log.info("Free memory: " + format.format(freeMemory / mb) + mega);
        log.info("Allocated memory: " + format.format(allocatedMemory / mb) + mega);
        log.info("Max memory: " + format.format(maxMemory / mb) + mega);
        log.info("Total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / mb) + mega);
        log.info("=================================================================");
    }

    @Bean
    public CommandLineRunner memInfoRunner() {
        return args -> printInfo();
    }

}
