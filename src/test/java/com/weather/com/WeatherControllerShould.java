package com.weather.com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
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
  @DisplayName("should return weather with zip code")
  void should_return_weather_with_zip_code() {
    weatherController.getWeatherByZipCode("01581");
    verify(weatherService).getWeatherByZip("01581");
  }
}
