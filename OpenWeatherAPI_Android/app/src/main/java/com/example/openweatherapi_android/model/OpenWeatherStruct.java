package com.example.openweatherapi_android.model;

import java.lang.reflect.Array;

public class OpenWeatherStruct {
    String name;
    int id;
    Coord coord;
    Main main;
    Weather weather;

    static class Coord {
        Double lon; // 經度
        Double lat; // 緯度
    }

    static class Main {
        Double temp;
        Double temp_min;
        Double temp_max;
        int humidity;
    }

    static class Weather {
        String icon;
        String main;
        String description;
    }
}
