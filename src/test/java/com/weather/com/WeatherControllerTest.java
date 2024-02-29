package com.weather.com;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.micronaut.http.client.annotation.*;
import jakarta.inject.Inject;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class WeatherControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

  @Test
  @DisplayName("should return weather from zip code")
  void should_return_weather_from_zip_code() {
    Weather weather = client.toBlocking().exchange("/weather/zip/01581", Weather.class).body();
    Assertions.assertThat(weather.location().name()).isEqualTo("Westborough");
  }
}
