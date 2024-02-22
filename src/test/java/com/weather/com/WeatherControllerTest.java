package com.weather.com;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.micronaut.http.client.annotation.*;
import jakarta.inject.Inject;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class WeatherControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    public void testIndex() throws Exception {
        assertEquals(HttpStatus.OK, client.toBlocking().exchange("/weather").status());
    }
    
    @Test
    @DisplayName("retrieve weather info by zip code")
    void retrieve_weather_info_by_zip_code() {
        assertEquals(HttpStatus.OK, client.toBlocking().exchange("/weather/zip/012").status());
    } 
}
