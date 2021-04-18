package com.shymmi.weatherApp.model;

import com.google.gson.annotations.JsonAdapter;
import com.shymmi.weatherApp.json_adapter.DateTimeAdapter;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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
        return printWeatherInfo(false);
    }

    public String toString(boolean imperial){
        if(!imperial){
            return this.toString();
        }

        return printWeatherInfo(true);
    }
    
    private String printWeatherInfo(boolean imperial){
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        return "Last update: " +dateTimeFormatter.format(last_updated)
                +"\nTemperature: " + ((imperial) ? (temp_f + " F") : (temp_c + " C"))
                +"\nFeels like: " + ((imperial) ? (feelslike_f + " F") : (feelslike_c + " C"))
                +"\nWind: " +wind_mph + " mph"
                +"\nPressure: " +pressure_mb + " mb";
    }
}
