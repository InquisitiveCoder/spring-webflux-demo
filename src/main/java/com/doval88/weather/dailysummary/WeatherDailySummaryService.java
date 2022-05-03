package com.doval88.weather.dailysummary;

import com.doval88.weather.gov.*;
import org.springframework.stereotype.*;
import reactor.core.publisher.*;
import lombok.extern.log4j.*;

@Log4j2
@Component
record WeatherDailySummaryService(WeatherService weatherService) implements DailySummaryService {
    @Override
    public Mono<DailySummaryResponse> dailySummary() {
        return weatherService.getForecast()
                .map(DailySummaryResponse::from)
                .map(response -> {
                    log.debug("Response: {}", response);
                    return response;
                });
    }
}
