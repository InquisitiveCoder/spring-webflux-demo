package com.doval88.weather.dailysummary;

import com.doval88.weather.gov.Period;
import com.doval88.weather.gov.*;
import com.doval88.weather.temperature.*;
import com.fasterxml.jackson.annotation.*;

import java.time.*;
import java.time.format.*;
import java.util.*;

public record DaySummary(
        @JsonProperty("day_name") String dayName,
        @JsonProperty("temp_high_celsius") double tempHighCelsius,
        @JsonProperty("forecast_blurp") String forecastBlurp) {
    @JsonCreator
    public DaySummary {}
    public static DaySummary from(Forecast forecast) {
        var periods = forecast.properties().periods();
        var day = periods.get(0);

        if (day.name().equals("Tonight")) {
            var name = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            return new DaySummary(name, getCelsius(day).value(), day.shortForecast());
        }

        var night = periods.get(1);
        if (day.temperature() > night.temperature()) {
            return new DaySummary(day.name(), getCelsius(day).value(), day.shortForecast());
        }

        // Use day.name() since night.name() will have a " Night" suffix.
        // Use night.shortForecast() since that's the forecast that corresponds to the temperature
        return new DaySummary(day.name(), getCelsius(night).value(), night.shortForecast());
    }

    private static Celsius getCelsius(Period period) {
        return Celsius.from(period.temperature(), period.temperatureUnit());
    }
}
