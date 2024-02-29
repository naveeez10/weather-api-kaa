package com.weather.com;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.*;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@MicronautTest
class WeatherControllerTest {

  @Inject
  @Client("/")
  HttpClient client;

  @Test
  @DisplayName("retrieve weather by zip code")
  void retrieve_weather_by_zip_code() {
    Weather weather = client.toBlocking().exchange("/weather/zip/01581", Weather.class).body();
    assertThat(weather.location().name()).isEqualTo("Westborough");
  }


  @Test
  @DisplayName("retrieve weather by city name")
  voiWeather weather = client.toBlocking().exchange("/weather/city/Westborough", Weather.class).body();
  assertThat(weather.location().name()).isEqualTo("Westborough");
}d retrieve_weather_by_city_name() {

}
