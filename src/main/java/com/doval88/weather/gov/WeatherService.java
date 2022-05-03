package com.doval88.weather.gov;

import reactor.core.publisher.*;

public interface WeatherService {
    Mono<Forecast> getForecast();
}
