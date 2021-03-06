package com.abidingtech.www.androidbactch11.Lecture26;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;

import com.abidingtech.www.androidbactch11.Lecture25.WifiActivity;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;



import com.abidingtech.www.androidbactch11.R;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, WifiActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);


    }
}