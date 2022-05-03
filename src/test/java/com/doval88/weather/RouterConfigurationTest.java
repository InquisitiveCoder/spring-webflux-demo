package com.doval88.weather;

import com.doval88.weather.dailysummary.*;
import com.doval88.weather.temperature.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.context.annotation.*;
import org.springframework.test.context.junit.jupiter.*;
import org.springframework.test.web.reactive.server.*;
import reactor.core.publisher.*;

import java.util.*;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;
import static org.springframework.http.MediaType.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class RouterConfigurationTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testHello() {
        var expected = new DailySummaryResponse(List.of(new DaySummary(
                "Monday", 27.0, "Partly Sunny")));
        webTestClient
                .get().uri("/forecast")
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(DailySummaryResponse.class).value(summary -> {
                    Assertions.assertEquals(summary, expected);
                });
    }

    @TestConfiguration
    public static class Configuration {
        @Bean
        @Primary
        public DailySummaryService dailySummaryService() {
            return () -> Mono.just(new DailySummaryResponse(List.of(new DaySummary(
                    "Monday", 27.0, "Partly Sunny"))));
        }
    }
}
