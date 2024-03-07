package com.weather.com;

import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

@Controller("/weather")
public class WeatherController {

  private final WeatherService weatherService;

  public WeatherController(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  @Get("/zip/{zip}")
  @ExecuteOn(TaskExecutors.BLOCKING)
  public Weather getWeatherByZipCode(String zip) {
    return weatherService.getWeatherByZip(zip);
  }
}
