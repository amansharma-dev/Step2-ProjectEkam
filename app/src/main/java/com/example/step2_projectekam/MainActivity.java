package com.example.step2_projectekam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.step2_projectekam.Data.AsyncIndianCitiesApi;
import com.example.step2_projectekam.Data.IndianCitiesApi;
import com.example.step2_projectekam.Model.IndianCities;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<IndianCities> indianCities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        indianCities = new IndianCitiesApi().getIndianCities(new AsyncIndianCitiesApi() {
            @Override
            public void processFinished(ArrayList<IndianCities> indianCitiesArrayList) {
                Log.d("MAIN", "processFinished: "+indianCitiesArrayList);
            }
        });

    }
}
