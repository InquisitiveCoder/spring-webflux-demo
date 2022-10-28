package com.doval88.weather;

import com.doval88.weather.dailysummary.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import org.springdoc.core.annotations.*;
import org.springframework.context.annotation.*;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
@OpenAPIDefinition(info = @Info(title = "Spring Reactive Demo", version = "1.0"))
public class RouterConfiguration {
    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/forecast",
                    produces = {APPLICATION_JSON_VALUE},
                    method = GET,
                    operation = @Operation(
                            operationId = "getForecast",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            content = @Content(
                                                    schema = @Schema(implementation = DailySummaryResponse.class)))}))})
    public RouterFunction<ServerResponse> route(DailySummaryHandler dailySummaryHandler) {
        return RouterFunctions.route(GET("/forecast").and(accept(APPLICATION_JSON)), dailySummaryHandler::forecast);
    }
}
