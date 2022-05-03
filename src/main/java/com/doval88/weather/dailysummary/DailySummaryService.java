package com.doval88.weather.dailysummary;

import reactor.core.publisher.*;

public interface DailySummaryService {
    Mono<DailySummaryResponse> dailySummary();
}
