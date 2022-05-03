package com.doval88.weather.dailysummary;

import lombok.*;
import lombok.extern.log4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.*;

import static org.springframework.http.MediaType.*;

@Log4j2
@Component
public record DailySummaryHandler(DailySummaryService service) {
    public Mono<ServerResponse> forecast(@NonNull ServerRequest request) {
        log.debug("Request: {}", request);
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(service.dailySummary(), DailySummaryResponse.class);
    }
}
