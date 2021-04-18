# Console Weather App

## Overview

Simple Java console based application to display weather based on user input.  

App was built in purpose to learn how to:
   1) Get data from extrnal API
   2) Deserialize JSON data accordingly
   3) Serve data to user

## Step by step

I will briefly discuss the steps by which I created this application

   1) Find the right API 
      - For this purpose I went to [RapidAPI](https://rapidapi.com/marketplace)
      - I found an API that meets my requirements and subscribed it
   2) Teste API Endpoint to find data structure
      - For this purpose I used Postman
   3) Build the proper structure in my project
   4) Use Unirest to reach the endpoint with the appropriate parameters  
   5) Deserialize received JSON using Gson
   6) Serve data to user

## How to run
   ### Preparation
   :bulb: Free Api key allows you to display weather up to 3 days.
   
   1. At first you need to get your API Key from [WeatherAPI](https://rapidapi.com/weatherapi/api/weatherapi-com)
   2. Past your API key in config file  
      ```(/src/main/java/com/shymmi/weatherApp/config/config.yml)```  
    
     host: HOST
     key: YOUR KEY
      
   ### Compile and exec  
   
 1) Compile files                
    ``` mvn clean install ```
    
 2) Exec main file  
    ``` mvn exec:java -Dexec.mainClass=com.shymmi.weatherApp.ConsoleWeatherAppMain ```
## Preview

![Prev](https://user-images.githubusercontent.com/15768915/115152944-b4353080-a073-11eb-80b1-de20babda71c.png)

## Conclusion

It's crucial to work with APIs these days. We use them when shopping, communicating with others online, making transfers and much more.
This weather application is pretty simple but shows how to communicate to external API to get the data.  


Is this correct written application to reach the data from API ?

At this moment the way I used to create this app is satisfactory for me.  
It may not be the best written app for this purpose but I done it myself and I'm happy with this.  

When I learn more about APIs and how to work with them i would happily improve this code.