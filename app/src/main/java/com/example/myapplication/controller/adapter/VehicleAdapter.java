package com.example.myapplication.controller.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.entity.Vehicle;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder> {

    Context context;
    List<Vehicle> vehicleList;

    public VehicleAdapter(Context context, List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
        this.context = context;
    }

    @Override
    public VehicleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.vehicle_recycler_item, null);
        VehicleViewHolder vehicleViewHolder = new VehicleViewHolder(view);
        return vehicleViewHolder;
    }

    @Override
    public void onBindViewHolder(VehicleViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // set the data

        Vehicle vehicle = vehicleList.get(position);
        holder.setDetails(vehicle);

        holder.vType.setText("Type: " + vehicleList.get(position).getType());
        holder.vLat.setText("Latitude: " + vehicleList.get(position).getLat());
        holder.vLng.setText("Long: " + vehicleList.get(position).getLng());
        holder.vBearing.setText("Bearing: " + vehicleList.get(position).getBearing());

        // implement setONCLickListtener on itemView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast
                Toast.makeText(context, vehicleList.get(position).getType(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return vehicleList.size(); // size of the list items
    }

    class VehicleViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView vType, vLat, vLng, vBearing;
        ImageView vImg;

        public VehicleViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            vType = (TextView) itemView.findViewById(R.id.vehicleType);
            vLat = (TextView) itemView.findViewById(R.id.vehicleLat);
            vLng = (TextView) itemView.findViewById(R.id.vehicleLng);
            vBearing = (TextView) itemView.findViewById(R.id.vehicleBearing);
            vImg = (ImageView) itemView.findViewById(R.id.imgProfile);
        }

        public void setDetails(Vehicle vehicle) {
            //this.cryptId.setText(crypto.getId());
            this.vType.setText(vehicle.getType());
            this.vLat.setText(vehicle.getLat());
            this.vLng.setText(Double.valueOf(vehicle.getLng()).toString());
            this.vBearing.setText(Integer.valueOf(vehicle.getBearing()).toString());
            Glide.with(itemView).load(vehicle.getImageUrl()).into(vImg);

        }
    }
}
