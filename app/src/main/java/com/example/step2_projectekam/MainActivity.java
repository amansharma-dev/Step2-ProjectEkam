package com.example.step2_projectekam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.step2_projectekam.Data.AsyncIndianCitiesApi;
import com.example.step2_projectekam.Data.IndianCitiesApi;
import com.example.step2_projectekam.Model.IndianCities;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<IndianCities> indianCities;
    private int currentIndex = 0;

    private TextView city;
    private TextView state;
    private TextView district;
    private CardView cardView;
    private ImageButton previous;
    private ImageButton next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.city_textView);
        state = findViewById(R.id.state_textView);
        district = findViewById(R.id.district_textView);
        cardView = findViewById(R.id.cardView);
        previous = findViewById(R.id.backButton);
        next = findViewById(R.id.nextButton);

        cardView.setCardBackgroundColor(getResources().getColor(R.color.colorText));
        cardView.setCardElevation(2.1f);

        previous.setOnClickListener(this);
        next.setOnClickListener(this);

        indianCities = new IndianCitiesApi().getIndianCities(new AsyncIndianCitiesApi() {
            @Override
            public void processFinished(ArrayList<IndianCities> indianCitiesArrayList) {


                city.setText(indianCitiesArrayList.get(currentIndex).getCity());
                state.setText(indianCitiesArrayList.get(currentIndex).getState());
                district.setText(indianCitiesArrayList.get(currentIndex).getDistrict());
                Log.d("MAIN", "processFinished: "+indianCitiesArrayList.get(0).getCity()+", "+indianCitiesArrayList.get(0).getState()+", "+indianCitiesArrayList.get(0).getDistrict());
            }
        });



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backButton:
                if(currentIndex>0){
                    currentIndex = (currentIndex -1) % indianCities.size();
                    updateIndianCities();
                }
                break;

            case R.id.nextButton:
                currentIndex = (currentIndex + 1) % indianCities.size();
                Toast.makeText(getApplicationContext(),"Can\'t go back ;)",Toast.LENGTH_SHORT).show();
                updateIndianCities();
                break;
        }
    }

    private void updateIndianCities(){
        String cityName = indianCities.get(currentIndex).getCity();
        String stateName = indianCities.get(currentIndex).getState();
        String districtName = indianCities.get(currentIndex).getDistrict();

        city.setText(cityName);
        state.setText(stateName);
        district.setText(districtName);
    }
}
