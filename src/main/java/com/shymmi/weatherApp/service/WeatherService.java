package com.shymmi.weatherApp.service;

import com.shymmi.weatherApp.model.Weather;

public interface WeatherService {

    Weather getWeateherForDaysByCity(String city, int days);
}
