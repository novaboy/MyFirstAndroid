package com.example.myapplication.service;

import com.example.myapplication.model.entity.VehicleList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VehicleApiInterface {

    @GET("vehicles.json")
    Call<VehicleList> getVehicleList();
}
