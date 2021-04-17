package com.shymmi.weatherApp.service.impl;

import com.shymmi.weatherApp.dao.WeatherDAO;
import com.shymmi.weatherApp.model.Weather;
import com.shymmi.weatherApp.service.WeatherService;

public class WeatherServiceImpl implements WeatherService {

    private final WeatherDAO weatherDAO;

    public WeatherServiceImpl() {
        weatherDAO = new WeatherDAO();
    }

    @Override
    public Weather getWeateherForDaysByCity(String city, int days) {
        return weatherDAO.getWeatherForDaysByCity(city, days);
    }
}
