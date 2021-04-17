package com.shymmi.weatherApp.model;

import com.google.gson.annotations.JsonAdapter;
import com.shymmi.weatherApp.json_adapter.DateAdapter;

import java.util.Date;

public class ForecastDay {

    @JsonAdapter(value = DateAdapter.class)
    private Date date;

    private Day day;
    private Astro astro;

}
