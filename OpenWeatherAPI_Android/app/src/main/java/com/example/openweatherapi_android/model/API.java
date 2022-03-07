package com.example.openweatherapi_android.model;

import retrofit2.Call;
import retrofit2.http.*;

public interface API {
    @GET("weather")
    Call<OpenWeatherStruct> getItem(@Query("q=") String cityName, @Query("appid=") String apiKey);
}

/*
【Android】Retrofit网络请求参数注解，@Path、@Query、@QueryMap...
https://www.jianshu.com/p/7687365aa946
 */