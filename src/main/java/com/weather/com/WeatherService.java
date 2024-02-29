package com.weather.com;

import jakarta.inject.Singleton;

@Singleton
public class WeatherService {
  WeatherApi weatherApi;

  public WeatherService(WeatherApi weatherApi) {
    this.weatherApi = weatherApi;
  }

  public Weather getWeatherByZip(String zip) {
      return weatherApi.getWeather(zip);
  }
}
