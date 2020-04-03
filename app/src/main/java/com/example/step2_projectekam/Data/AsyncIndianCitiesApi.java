package com.example.step2_projectekam.Data;

import com.example.step2_projectekam.Model.IndianCities;

import java.util.ArrayList;

public interface AsyncIndianCitiesApi {
    void processFinished(ArrayList<IndianCities> indianCitiesArrayList);
}
