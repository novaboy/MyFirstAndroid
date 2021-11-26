package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;


import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.controller.adapter.VehicleAdapter;
import com.example.myapplication.model.entity.VehicleList;
import com.example.myapplication.service.VehicleApiInterface;
import com.example.myapplication.service.VehicleServiceGenerator;

import retrofit2.*;

public class RetrofitJsonRecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    VehicleList vehicleList = new VehicleList();
    VehicleAdapter vehicleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_json);
        getVehicleList();


        recyclerView = (RecyclerView) findViewById(R.id.recyclerVehicle);



        setDataInRecyclerView();

    }


    private void getVehicleList(){
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(RetrofitJsonRecyclerActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialog

        VehicleApiInterface vehicleApi = VehicleServiceGenerator.createService(VehicleApiInterface.class);
        Call<VehicleList>  call = vehicleApi.getVehicleList();
        call.enqueue(new Callback<VehicleList>() {

                         @Override
                         public void onResponse(Call<VehicleList> call, Response<VehicleList> response) {
                             if (response.isSuccessful() && response.body() != null && response.code() == 200 ) {
                                 // in this method we will get the response from API
                                 progressDialog.dismiss(); //dismiss progress dialog
                                 vehicleList.setVehicles(response.body().getVehicles());
                                 vehicleAdapter = new VehicleAdapter(RetrofitJsonRecyclerActivity.this, vehicleList.getVehicles());
                                 recyclerView.setAdapter(vehicleAdapter); // set the Adapter to RecyclerView
                             } else {
                                 Log.d("Error message", response.message());
                             }
                         }

                         @Override
                         public void onFailure(Call<VehicleList> call, Throwable t) {
                             Toast.makeText(RetrofitJsonRecyclerActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                             progressDialog.dismiss(); //dismiss progress dialog
                         }
                     });


        // Api is a class in which we define a method getClient() that returns the API Interface class object
        // getUsersList() is a method in API Interface class, in this method we define our API sub url

//        Call<VechicleList> call = VehicleApi.getClient().getVehicleList();

//        new Thread(new Runnable(){
//            @Override
//            public void run() {
//                try {
//                    vehicleList = call.execute().body();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();



//        call.enqueue(new Callback<VechicleList>() {
//
//            @Override
//            public void onResponse(Call<VechicleList> call, Response<VechicleList> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    // in this method we will get the response from API
//                    progressDialog.dismiss(); //dismiss progress dialog
//                    vehicleList.setVehicles(response.body().getVehicles());
//                    setDataInRecyclerView(); // call this method to set the data in adapter
//                } else {
//                    Log.d("Error message",response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<VechicleList> call, Throwable t) {
//                Toast.makeText(RetrofitJsonRecyclerActivity.this, t.toString(), Toast.LENGTH_LONG).show();
//                progressDialog.dismiss(); //dismiss progress dialog
//            }
//
//        });




    }


    private void setDataInRecyclerView() {
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RetrofitJsonRecyclerActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of UsersAdapter to send the reference and data to Adapter
//        VehicleAdapter vehicleAdapter = new VehicleAdapter(RetrofitJsonRecyclerActivity.this, vehicleList.getVehicles());
//        recyclerView.setAdapter(vehicleAdapter); // set the Adapter to RecyclerView
    }
}