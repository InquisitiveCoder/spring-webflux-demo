package com.doval88.weather.gov;

import java.util.*;

public record Forecast(Properties properties) {
    public record Properties(List<Period> periods) {
    }
}
