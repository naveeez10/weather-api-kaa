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
class WeatherControllerShould {

  @Mock WeatherService weatherService;
  WeatherController weatherController;

  @BeforeEach
  public void init() {
    weatherController = new WeatherController(weatherService);
  }

  @Test
  @DisplayName("calls_weather_service_get_by_zip_method")
  void calls_weather_service_get_by_zip_method() {
    Weather weather = weatherController.getByZip("0123");
    verify(weatherService).getByZip("0123");
  }

  @Test
  @DisplayName("calls weather service get by city name method")
  void calls_weather_service_get_by_city_name_method() {
    Weather weather = weatherController.getByCity("Westborough");
    verify(weatherService).getByCity("Westborough");
  }
}
