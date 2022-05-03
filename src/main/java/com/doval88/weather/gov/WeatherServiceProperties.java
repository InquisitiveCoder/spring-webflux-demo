package com.doval88.weather.gov;

import org.springframework.boot.context.properties.*;

@ConfigurationProperties("weather-service")
public record WeatherServiceProperties(String hostname, String forecastUrl) {
}
