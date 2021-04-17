package com.shymmi.weatherApp.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.shymmi.weatherApp.model.Weather;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

public class WeatherDAO {

    private static final String KEY = "YOUR_KEY";
    private static final String HOST = "weatherapi-com.p.rapidapi.com";

    public Weather getWeatherForDaysByCity(String city, int days) {
        String response = getDataFromWeatherAPI(city,days).getBody().toString();

        return parseJSONDataToWeatherClass(response);
    }

    private HttpResponse<JsonNode> getDataFromWeatherAPI(String city, int days){
        HttpResponse<JsonNode> response = Unirest.get("https://weatherapi-com.p.rapidapi.com/forecast.json")
                                    .queryString("q", city)
                                    .queryString("days", days)
                                    .header("x-rapidapi-key", KEY)
                                    .header("x-rapidapi-host", HOST)
                                    .asJson();
        return response;
    }

    private Weather parseJSONDataToWeatherClass(String jsonString){

        Gson gson = new Gson();

        return gson.fromJson(jsonString, Weather.class);
    }
}
