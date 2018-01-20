package com.example.fartakstok.weather.api.weather.current;

import com.example.fartakstok.weather.api.RetrofitBuilder;
import com.example.fartakstok.weather.model.CurrentWeather;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by fartakstok on 01/14/2018.
 */

public class CurrentWeatherApiRequest {

    public static void getCurrentWeather(String cityName,Callback<CurrentWeather> callback) {

        Retrofit retrofit = RetrofitBuilder.getRetrofit();

        CurrentWeatherApi currentWeatherApi = retrofit.create(CurrentWeatherApi.class);

        Call<CurrentWeather> currentWeather = currentWeatherApi.getCurrentWeather("2.5",cityName,RetrofitBuilder.APP_ID);

        currentWeather.enqueue(callback);
    }
}
