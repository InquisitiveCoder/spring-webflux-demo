package com.doval88.weather.temperature;

import com.fasterxml.jackson.annotation.*;


public record Celsius(double value) {
    @JsonCreator
    public Celsius {

    }
    public static Celsius from(double magnitude, TemperatureUnit unit) {
        return switch (unit) {
            case C -> new Celsius(magnitude);
            case F -> new Celsius((magnitude - 32.0) * 5 / 9);
            case K -> new Celsius(magnitude - 273.15);
        };
    }

    @JsonValue
    public double value() {
        return value;
    }
}
