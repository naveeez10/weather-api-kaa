package com.weather.com;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WeatherServiceShould {

  WeatherService weatherService;
  @Mock WeatherApi weatherApi;
  @BeforeEach
  void setUp() {
    weatherService = new WeatherService(weatherApi);
  }

  @Test
  @DisplayName("should call weather client to retrieve realtime weather data from the api through zip code")
  void should_call_weather_client_to_retrieve_realtime_weather_data_from_the_api_through_zip_code() {
    weatherService.getWeatherByZip("01581");
    verify(weatherApi).getWeather("01581");
  }
}
