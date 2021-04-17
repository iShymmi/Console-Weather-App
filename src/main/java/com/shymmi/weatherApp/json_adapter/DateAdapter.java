package com.shymmi.weatherApp.json_adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends TypeAdapter<Date> {
    @Override
    public void write(JsonWriter jsonWriter, Date date) throws IOException {

    }

    @Override
    public Date read(JsonReader jsonReader) throws IOException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return df.parse(jsonReader.nextString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
