package com.shymmi.weatherApp;

import com.shymmi.weatherApp.config.ConnectionConfig;
import com.shymmi.weatherApp.model.Current;
import com.shymmi.weatherApp.model.Forecast;
import com.shymmi.weatherApp.model.Location;
import com.shymmi.weatherApp.model.Weather;
import com.shymmi.weatherApp.service.WeatherService;
import com.shymmi.weatherApp.service.impl.WeatherServiceImpl;

import java.util.Scanner;

public class ConsoleWeatherAppMain {
    private Weather weather;
    private boolean exit;
    private boolean imperial;
    private final Scanner scanner;

    public ConsoleWeatherAppMain() {
        WeatherService weatherService = new WeatherServiceImpl();

        printConfigurationInfo();

        scanner = new Scanner(System.in);

        String city;
        int days;

        System.out.println("Use metric [1] or imperial [2] ?");
        if(scanner.nextLine().equals("2")) {
            imperial = true;
        }

        while(!exit) {
            System.out.println("For which location do you want the weather");
            city = scanner.nextLine();
            System.out.println("For how many days do you want the weather");
            try{
                days = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Invalid input");
                continue;
            }

            weather = weatherService.getWeateherForDaysByCity(city,days);

            if(weather == null) {
                System.out.println("Weather for this location not found");
                continue;
            }

            printCurrentWeatherInfo(weather,imperial);
            System.out.println("");
            optionMenu();
        }
    }

    public static void main(String... args){
        ConsoleWeatherAppMain consoleWeatherAppMain = new ConsoleWeatherAppMain();
    }

    private void printCurrentWeatherInfo(Weather weather, boolean imperial){
        Current current = weather.getCurrent();
        Location location = weather.getLocation();

        System.out.println("-------------------------------------------------------------");
        System.out.println("Location:");
        System.out.println(location.toString());

        System.out.println("\nCurrent weather:");
        System.out.println(current.toString(imperial));
        System.out.println("-------------------------------------------------------------");
    }

    private void printFurtherDaysInfo(Weather weather, boolean imperial){
        Forecast forecast = weather.getForecast();
        System.out.println("\nFurther days weather:");
        System.out.println(forecast.toString(imperial));
        System.out.println(" ------------------------------------------------------------------------");
    }

    private void printConfigurationInfo(){
        System.out.println("Configuration info: ");
        ConnectionConfig config = ConnectionConfig.getInstance();
        System.out.println(config.toString() +"\n");
    }

    private void optionMenu(){
        System.out.println("What to do: ");
        System.out.println("[0] Print further days info\n"
                +"[1] Look for another city\n"
                +"[2] Exit");

        String option = scanner.nextLine();

        switch (option) {
            case "0" :
                printFurtherDaysInfo(weather, imperial);
                optionMenu();
                break;
            case "2" :
                exit = true;
                break;
            default:
                break;
        }
    }
}
