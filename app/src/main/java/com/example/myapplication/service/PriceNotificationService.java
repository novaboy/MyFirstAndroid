package com.example.myapplication.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.activity.CryptoRecyclerActivity;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class PriceNotificationService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("CryptoChannel",
                    "Crypto Channel",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Crypto price monitor");
            mNotificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "CryptoChannel")
                .setSmallIcon(R.mipmap.ic_launcher) // notification icon
                .setContentTitle("Crypto Watcher Service") // title for notification
                .setContentText("Bitcoin price plummets...")// message for notification
                .setOngoing(true)
                .setAutoCancel(false); // clear notification after click

        Intent intent = new Intent(getApplicationContext(), CryptoRecyclerActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pi);

        startForeground(56, mBuilder.build());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        showToast();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    void showToast() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(PriceNotificationService.this, "Bitcoin price crossed the threshold ....", Toast.LENGTH_SHORT).show();
                showToast();
            }
        }, 5000);
    }
}
