package com.shymmi.weatherApp.model;

import lombok.Getter;

@Getter
public class Location {

    private String name;
    private String country;

    @Override
    public String toString() {
        return country +", " +name;
    }
}
