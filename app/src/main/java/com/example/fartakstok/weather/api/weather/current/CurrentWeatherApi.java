package com.example.fartakstok.weather.api.weather.current;

import com.example.fartakstok.weather.model.CurrentWeather;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by fartakstok on 01/14/2018.
 */

public interface CurrentWeatherApi {
//    q=Rasht&APPID=1d1d8ece44d7bfc6fe8b12a3ef0f5087
//    2.5
    @GET("data/{version}/weather")
    Call<CurrentWeather> getCurrentWeather(@Path("version") String version, @Query("q") String cityName, @Query("APPID") String appId);

    @GET
    Call<CurrentWeather> getCurrentWeather(@Url String dynamicUrl);
}
