package com.example.myapplication.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VehicleApi{

    public static VehicleApiInterface getClient() {


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://pouyaheydari.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        //Creating object for our interface
        VehicleApiInterface api = retrofit.create(VehicleApiInterface.class);
        return api; // return the APIInterface object
    }
}
