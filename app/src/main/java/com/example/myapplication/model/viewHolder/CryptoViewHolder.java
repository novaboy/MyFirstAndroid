package com.example.myapplication.model.viewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.entity.Cryptocurrency;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CryptoViewHolder extends RecyclerView.ViewHolder {

    TextView cryptName, cryptAbbr, cryptLaunch, cryptCircleSupply, cryptMaxSupply, cryptNetwork, cryptBlockTime;
    Button btnMonitor;

    public CryptoViewHolder(@NonNull View itemView) {
        super(itemView);
        this.cryptName = itemView.findViewById(R.id.cryptName);
        this.cryptAbbr = itemView.findViewById(R.id.cryptAbbr);
        this.cryptLaunch = itemView.findViewById(R.id.cryptLaunch);
        this.cryptCircleSupply = itemView.findViewById(R.id.cryptCircleSupply);
        this.cryptMaxSupply = itemView.findViewById(R.id.cryptMaxSupply);
        this.cryptNetwork = itemView.findViewById(R.id.cryptNetwork);
        this.cryptBlockTime = itemView.findViewById(R.id.cryptBlockTime);
        this.btnMonitor = itemView.findViewById(R.id.btnMonitor);
    }

    public void setDetails (Cryptocurrency crypto){
        //this.cryptId.setText(crypto.getId());
        this.cryptName.setText(crypto.getName());
        this.cryptAbbr.setText(crypto.getAbbr());
        this.cryptLaunch.setText(crypto.getLaunch());
        this.cryptCircleSupply.setText(crypto.getCirculateSupply());
        this.cryptMaxSupply.setText(crypto.getMaxSupply());
        this.cryptNetwork.setText(crypto.getNetwokrk());
        this.cryptBlockTime.setText(crypto.getBlockTime());

        switch (crypto.isMonitorFlag()){
            case 0:
                this.btnMonitor.setText("Start Monitor");
                break;
            case 1:
                this.btnMonitor.setText("stop Monitor");
                break;
        }
    }
}
