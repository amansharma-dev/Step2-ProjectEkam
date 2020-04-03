package com.example.step2_projectekam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.step2_projectekam.Data.AsyncIndianCitiesApi;
import com.example.step2_projectekam.Data.IndianCitiesApi;
import com.example.step2_projectekam.Model.IndianCities;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<IndianCities> indianCities;
    private int currentIndex = 0;

    private TextView city;
    private TextView state;
    private TextView district;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.city_textView);
        state = findViewById(R.id.state_textView);
        district = findViewById(R.id.district_textView);
        cardView = findViewById(R.id.cardView);

        cardView.setCardBackgroundColor(getResources().getColor(R.color.colorCard));
        cardView.setCardElevation(2.1f);

        indianCities = new IndianCitiesApi().getIndianCities(new AsyncIndianCitiesApi() {
            @Override
            public void processFinished(ArrayList<IndianCities> indianCitiesArrayList) {


                city.setText(indianCitiesArrayList.get(currentIndex).getCity());
                city.setText(indianCitiesArrayList.get(currentIndex).getState());
                city.setText(indianCitiesArrayList.get(currentIndex).getDistrict());
                Log.d("MAIN", "processFinished: "+indianCitiesArrayList.get(0).getCity()+", "+indianCitiesArrayList.get(0).getState()+", "+indianCitiesArrayList.get(0).getDistrict());
            }
        });


    }
}
