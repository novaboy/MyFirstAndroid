package com.example.myapplication.service.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BreakingNewsBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String msg = intent.getStringExtra("msg");
        int displayDuration = 0;
        switch(intent.getStringExtra("priority")){
            case "high":
                displayDuration = 1;
                break;
            case "low":
                displayDuration = 0;
            default:
                break;
        }
        Toast.makeText(context, msg, displayDuration).show();
    }
}
