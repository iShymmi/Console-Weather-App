package com.shymmi.weatherApp.model;

import lombok.Getter;

import static java.util.Arrays.stream;

@Getter
public class Forecast {
    private ForecastDay[] forecastday;

    @Override
    public String toString() {
        return getForecastInfo(false);
    }

    public String toString(boolean imperial) {
        if(!imperial) {
            return toString();
        }

        return getForecastInfo(imperial);
    }

    private String getForecastInfo(boolean imperial) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|     Date     |   Temp min   |   Temp max   |  Sunrise   |   Sunset    |");

        stream(forecastday).forEach(forecastDay -> {
            stringBuilder.append("\n -----------------------------------------------------------------------");
            stringBuilder.append("\n").append(forecastDay.toString(imperial));
        });

        return stringBuilder.toString();
    }
}
