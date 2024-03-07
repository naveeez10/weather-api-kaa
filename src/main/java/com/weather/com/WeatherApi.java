package com.weather.com;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client("https://api.weatherapi.com/v1/")
public interface WeatherApi {
  @Get("current.json?key=f3a0c75f9c35485098263516240703&q={q}&aqi=no")
  Weather getWeather(@QueryValue("q") String query);
}
