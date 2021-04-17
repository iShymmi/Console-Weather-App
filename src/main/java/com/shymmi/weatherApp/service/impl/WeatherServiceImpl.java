package com.shymmi.weatherApp.service.impl;

import com.shymmi.weatherApp.config.ConnectionConfig;
import com.shymmi.weatherApp.dao.WeatherDAO;
import com.shymmi.weatherApp.model.Weather;
import com.shymmi.weatherApp.service.WeatherService;

public class WeatherServiceImpl implements WeatherService {

    private final WeatherDAO weatherDAO;

    public WeatherServiceImpl() {
        ConnectionConfig connectionConfig = ConnectionConfig.getInstance();

        weatherDAO = new WeatherDAO(connectionConfig.getKey(), connectionConfig.getHost());
    }

    @Override
    public Weather getWeateherForDaysByCity(String city, int days) {
        return weatherDAO.getWeatherForDaysByCity(city, days);
    }
}
