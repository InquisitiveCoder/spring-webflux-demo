package com.doval88.weather;

import com.doval88.weather.dailysummary.*;
import org.springframework.context.annotation.*;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class RouterConfiguration {
    @Bean
    public RouterFunction<ServerResponse> route(DailySummaryHandler dailySummaryHandler) {
        return RouterFunctions.route(GET("/forecast").and(accept(APPLICATION_JSON)), dailySummaryHandler::forecast);
    }
}
