package com.weather.com;

import io.micronaut.http.annotation.*;

@Controller("/weather")
public class WeatherController {

  private final WeatherService weatherService;

  public WeatherController(WeatherService weatherService) {

    this.weatherService = weatherService;
  }

  @Get(uri = "/", produces = "text/plain")
  public String index() {
    return "Example Response";
  }

  public Weather getByZip(String zip) {
    return weatherService.getByZip(zip);
  }
}
