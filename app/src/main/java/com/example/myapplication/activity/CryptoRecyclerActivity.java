package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.myapplication.R;
import com.example.myapplication.controller.adapter.CryptoAdapter;
import com.example.myapplication.model.entity.Cryptocurrency;
import com.example.myapplication.service.PriceNotificationService;

import java.util.ArrayList;

public class CryptoRecyclerActivity extends AppCompatActivity {

    ArrayList<Cryptocurrency>  cryptocurrencyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_crypto);

        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);


        cryptocurrencyList = new ArrayList<>();
        cryptocurrencyList.add(new Cryptocurrency(1, "Bitcoin","BTC","2009",">17 miilion","21 million","n/a","10 min",0));
        cryptocurrencyList.add(new Cryptocurrency(2, "Bitcoin cash","BCH","2017",">17 miilion","21 million","n/a","10 min",0));
        cryptocurrencyList.add(new Cryptocurrency(3, "Ether","ETH","2015",">102 miilion","No upper limit","Ethereum","15 min",0));
        cryptocurrencyList.add(new Cryptocurrency(4, "Litecoin","LTC","2011",">58 miilion","84 million","n/a","2 minutes 30 seconds",0));
        cryptocurrencyList.add(new Cryptocurrency(5, "EOS","EOS","2018",">906 miilion","No upper limit","EOS.IO","0.5 seconds",0));
        cryptocurrencyList.add(new Cryptocurrency(6, "Stellar","XLM","2014",">18 miilion","No upper limit","Stellar","5 seconds",0));
        cryptocurrencyList.add(new Cryptocurrency(7, "NEO","NEO","2014",">65 miilion","100 million","NEO","15 seconds",0));


//        LinearLayoutManager manager = new GridLayoutManager(this, 2);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        DividerItemDecoration  itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{0xfff7f7f7, 0xfff7f7f7});
        drawable.setSize(1,1);
        itemDecoration.setDrawable(drawable);
        recycler.addItemDecoration(itemDecoration);


        recycler.setLayoutManager(manager);

        CryptoAdapter adapter = new CryptoAdapter(cryptocurrencyList);
        recycler.setAdapter(adapter);





    }

    public void btnClicked(View view) {
        Button btnMonitor = findViewById(R.id.btnMonitor);

        if (btnMonitor.getText().equals("Start Monitor")){
            btnMonitor.setText("Stop Monitor");
            Intent intent = new Intent(CryptoRecyclerActivity.this, PriceNotificationService.class);
            startForegroundService(intent);
        } else {
            btnMonitor.setText("Start Monitor");
            Intent intent = new Intent(CryptoRecyclerActivity.this, PriceNotificationService.class);
            stopService(intent);
        }
    }
}