package com.example.fartakstok.weather.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fartakstok on 01/14/2018.
 */

public class RetrofitBuilder {

    public static final String APP_ID = "1d1d8ece44d7bfc6fe8b12a3ef0f5087";
    public static final String BASE_URL = "http://api.openweathermap.org/";

    public static Retrofit getRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder();
        return builder.baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
