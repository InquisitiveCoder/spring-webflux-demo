package com.doval88.weather.gov;

import lombok.extern.log4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.*;

import static org.springframework.http.MediaType.*;

@Log4j2
@Component
record WeatherServiceClient(WebClient client, WeatherServiceProperties props) implements WeatherService {
    @Autowired
    public WeatherServiceClient(WebClient.Builder builder, WeatherServiceProperties props) {
        this(builder.baseUrl(props.hostname()).build(), props);
        log.debug("{}", props);
    }

    @Override
    public Mono<Forecast> getForecast() {
        log.debug("GET {}{}", props.hostname(), props.forecastUrl());
        return client.get().uri(props.forecastUrl()).accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Forecast.class)
                .map(response -> {
                    log.debug("Response: {}", response);
                    return response;
                });
    }
}
