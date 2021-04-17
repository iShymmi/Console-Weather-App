package com.shymmi.weatherApp.model;

import lombok.Getter;

@Getter
public class Weather {

    private Location location;
    private Current current;
    private Forecast forecast;

    @Override
    public String toString() {
        return super.toString();
    }
}
