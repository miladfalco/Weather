package com.example.fartakstok.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fartakstok.weather.api.weather.current.CurrentWeatherApiRequest;
import com.example.fartakstok.weather.model.CurrentWeather;

import org.json.JSONObject;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<CurrentWeather> {

    private EditText editCityName;
    private TextView textView;

    public static final String TAG = "==> Main";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        Log.i(TAG, "onCreate: ");

//            editCityName = findViewById(R.id.editCityName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    public void onGetCurrentWeather(View view) {

        String city = editCityName.getText().toString();
        CurrentWeatherApiRequest.getCurrentWeather(city, this);

    }

    @Override
    public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {

        Log.i(TAG, "onResponse: " + response.code());

        if (response.isSuccessful()) {
            CurrentWeather body = response.body();
            Long pressure = body.getMain().getPressure();
            String name = body.getName();
            String description = body.getWeather().get(0).getDescription();

            Toast.makeText(this, " Weather " + description, Toast.LENGTH_SHORT).show();
            Log.i(TAG, "onResponse: pressure " + pressure + " name " + name + " des " + description);

        } else {
            Toast.makeText(this, "onResponse Failed", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onFailure(Call<CurrentWeather> call, Throwable t) {
        Log.i("===>", "onFailure: ");

    }

    public void onClick(View view) {
        textView.setText("HELLOOOOOOO");
        startActivity(new Intent(this, SecondActivity.class));
    }
}
