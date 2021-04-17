package com.shymmi.weatherApp.model;

import com.google.gson.annotations.JsonAdapter;
import com.shymmi.weatherApp.json_adapter.DateTimeAdapter;
import lombok.Getter;

import java.util.Date;

@Getter
public class Current {

    @JsonAdapter(value = DateTimeAdapter.class)
    private Date last_updated;

    private double temp_c;
    private double temp_f;
    private double feelslike_c;
    private double feelslike_f;
    private double wind_mph;
    private double pressure_mb;

    @Override
    public String toString() {
        return "Last update: " +last_updated
                +"\nTemperature: " +temp_c
                +"\nFeels like: " +feelslike_c
                +"\nWind: " +wind_mph
                +"\nPressure: " +pressure_mb;
    }
}
