package com.doval88.weather.dailysummary;

import com.doval88.weather.gov.*;

import java.util.*;

public record DailySummaryResponse(List<DaySummary> daily) {
    public static DailySummaryResponse from(Forecast forecast) {
        return new DailySummaryResponse(List.of(DaySummary.from(forecast)));
    }
}
