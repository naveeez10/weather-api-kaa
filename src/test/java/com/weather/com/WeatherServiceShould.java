package com.weather.com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WeatherServiceShould {
  @Mock WeatherApi weatherApi;

  WeatherService weatherService;

  @BeforeEach
  public void init() {
    weatherService = new WeatherService(weatherApi);
  }

  @Test
  @DisplayName(
      "should call the http client to retrieve real time weather data from the web service")
  void should_call_the_http_client_to_retrieve_real_time_weather_data_from_the_web_service() {
    weatherService.getByZip("0123");
    verify(weatherApi).getWeather("0123");
  }

  @Test
  @DisplayName("should call the http client to retrieve real time weather data by city name")
  void should_call_the_http_client_to_retrieve_real_time_weather_data_by_city_name() {
    weatherService.getByCity("Westborough");
    verify(weatherApi).getWeather("Westborough");
  }
}
