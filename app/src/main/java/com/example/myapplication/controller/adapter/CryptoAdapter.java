package com.example.myapplication.controller.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.model.entity.Cryptocurrency;
import com.example.myapplication.model.viewHolder.CryptoViewHolder;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CryptoAdapter extends RecyclerView.Adapter<CryptoViewHolder> {

    ArrayList<Cryptocurrency> cryptoList;

    public CryptoAdapter(ArrayList<Cryptocurrency> cryptoList) {
        this.cryptoList = cryptoList;
    }

    @NonNull
    @Override
    public CryptoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crypto_recycler_item, parent, false);
        CryptoViewHolder cryptoViewHolder = new CryptoViewHolder(view);
        return cryptoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoViewHolder holder, int position) {
        Cryptocurrency cryptocurrency = cryptoList.get(position);
        holder.setDetails(cryptocurrency);

    }

    @Override
    public int getItemCount() {
        return cryptoList.size();
    }


}
