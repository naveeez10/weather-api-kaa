package com.weather.com;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Singleton;

@Client("https://api.weatherapi.com/v1/")
public interface WeatherApi {

    @Get("current.json?key=88ac638e9c024faca3c51331242202&q={q}&aqi=no")
    Weather getWeather(@QueryValue("q") String zip);
}
