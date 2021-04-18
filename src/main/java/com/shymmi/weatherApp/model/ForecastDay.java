package com.shymmi.weatherApp.model;

import com.google.gson.annotations.JsonAdapter;
import com.shymmi.weatherApp.json_adapter.DateAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ForecastDay {

    @JsonAdapter(value = DateAdapter.class)
    private Date date;

    private Day day;
    private Astro astro;

    @Override
    public String toString() {
        return getForecastDayInfo(false);
    }

    public String toString(boolean imperial){
        if(!imperial) {
            return toString();
        }

        return getForecastDayInfo(imperial);
    }

    private String getForecastDayInfo(boolean imperial){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return String.format("|  %10s  |%8s      | %8s     |  %7s  |   %7s  |",
                dateFormat.format(date),
                ((!imperial) ? day.getMintemp_c() + " C" : day.getMintemp_f() + " F"),
                ((!imperial) ? day.getMaxtemp_c() + " C" : day.getMaxtemp_f() + " F"),
                astro.getSunrise(),
                astro.getSunset());
    }
}
