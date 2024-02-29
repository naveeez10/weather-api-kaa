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

  @Get(uri = "/zip/{zip}")
  @ExecuteOn(TaskExecutors.BLOCKING)
  public Weather getByZip(String zip) {
    return weatherService.getByZip(zip);
  }

  @Get(uri = "/city/{city}")
  @ExecuteOn(TaskExecutors.BLOCKING)
  public Weather getByCity(String city) {
    return weatherService.getByCity(city);
  }
}
