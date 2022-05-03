package com.doval88.weather;

import org.springframework.boot.autoconfigure.jackson.*;
import org.springframework.context.annotation.*;

import static com.fasterxml.jackson.databind.PropertyNamingStrategies.*;

@Configuration
public class JacksonConfiguration {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> builder.propertyNamingStrategy(SNAKE_CASE);
    }
}
