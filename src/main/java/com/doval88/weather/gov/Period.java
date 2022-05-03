package com.doval88.weather.gov;

import com.doval88.weather.temperature.*;

public record Period(
        String name,
        int temperature,
        TemperatureUnit temperatureUnit,
        String shortForecast) {
}
