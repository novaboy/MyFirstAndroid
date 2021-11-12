package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Activity activity ;
    private ProgressDialog progDailog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        VideoView vv = findViewById(R.id.vv);
        String url = "https://aspb2.cdn.asset.aparat.com/aparat-video/725afc5efd2131836df4f725d84f44a111942398-148p.mp4?wmsAuthSign=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6ImNhNzlkMjdiMjdkNjQ1MmUxMzkyYTQyZjZjYjY3ZTI3IiwiZXhwIjoxNjM2MTA3ODY5LCJpc3MiOiJTYWJhIElkZWEgR1NJRyJ9.fxGnsidy8-RK3sdOAbZdUK1c-pekNucI3WQrtS0amOg";
        vv.setVideoURI(Uri.parse(url));
        vv.setMediaController(new MediaController(MainActivity.this));
        vv.start();


        activity = this;
        progDailog = ProgressDialog.show(activity, "Loading","Please wait...", true);
        progDailog.setCancelable(false);



        WebView web = findViewById(R.id.web);

        if (Build.VERSION.SDK_INT >= 19) {
            web.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }

        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setLoadWithOverviewMode(true);
        web.getSettings().setUseWideViewPort(true);
        web.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progDailog.show();
                view.loadUrl(url);

                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                progDailog.dismiss();
            }
        });

        web.loadUrl("https://www.ibm.com/se-en/topics/what-is-blockchain");

        LinearLayout drawer = (LinearLayout) findViewById(R.id.drawer);
        drawer.setAlpha(1f);


Intent intent = getIntent();
intent.getExtras();



    }
}