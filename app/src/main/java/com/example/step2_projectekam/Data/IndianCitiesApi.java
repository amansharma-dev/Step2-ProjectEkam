package com.example.step2_projectekam.Data;

import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.step2_projectekam.Controller.AppController;
import com.example.step2_projectekam.Model.IndianCities;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class IndianCitiesApi {
    public static final  String url = "https://indian-cities-api-nocbegfhqg.now.sh/cities";

    ArrayList<IndianCities> indianCitiesArrayList = new ArrayList<>();

    public List<IndianCities> getIndianCities(final AsyncIndianCitiesApi callback){

        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i=0; i<response.length() ; i++){
                            IndianCities indianCities = new IndianCities();
                            try {
                                indianCities.setCity(response.getJSONObject(i).getString("City"));
                                indianCities.setState(response.getJSONObject(i).getString("State"));
                                indianCities.setDistrict(response.getJSONObject(i).getString("District"));

                                indianCitiesArrayList.add(indianCities);
                               // Log.d("INDIANCITIES", "onResponse: "+response.getJSONObject(i).getString("City")+ ", "+response.getJSONObject(i).getString("State")+", "+response.getJSONObject(i).getString("District"));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        if(null != callback){
                            callback.processFinished(indianCitiesArrayList);
                        }


                        //Log.d("RESPONSE", "onResponse: "+response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("VOLLEYERROR", "onErrorResponse: "+error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        return indianCitiesArrayList;
    }

}
