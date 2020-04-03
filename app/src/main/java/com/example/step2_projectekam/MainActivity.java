package com.example.step2_projectekam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.step2_projectekam.Data.IndianCitiesApi;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IndianCitiesApi indianCitiesApi = new IndianCitiesApi();
        indianCitiesApi.getIndianCities();
    }
}
