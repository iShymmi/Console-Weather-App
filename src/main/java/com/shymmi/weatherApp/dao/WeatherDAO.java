package com.shymmi.weatherApp.dao;

import com.google.gson.Gson;
import com.shymmi.weatherApp.model.Weather;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class WeatherDAO {

    private final String key;
    private final String host;

    public WeatherDAO(String key, String host) {
        this.key = key;
        this.host = host;
    }

    public Weather getWeatherForDaysByCity(String city, int days) {
        String response = getDataFromWeatherAPI(city,days).getBody().toString();

        return parseJSONDataToWeatherClass(response);
    }

    private HttpResponse<JsonNode> getDataFromWeatherAPI(String city, int days){
        HttpResponse<JsonNode> response = Unirest.get("https://weatherapi-com.p.rapidapi.com/forecast.json")
                                    .queryString("q", city)
                                    .queryString("days", days)
                                    .header("x-rapidapi-key", key)
                                    .header("x-rapidapi-host", host)
                                    .asJson();
        return response;
    }

    private Weather parseJSONDataToWeatherClass(String jsonString){

        Gson gson = new Gson();
        Weather weather;

        weather = gson.fromJson(jsonString, Weather.class);

        if(weather.getLocation() == null){
            return null;
        }

        return weather;
    }
}
