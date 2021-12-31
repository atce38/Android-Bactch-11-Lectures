package com.abidingtech.www.androidbactch11.Lecture8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.abidingtech.www.androidbactch11.Common.Common;
import com.abidingtech.www.androidbactch11.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView btnLogout=findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    private void logout() {
//        SharedPreferences.Editor sp=getSharedPreferences("login",MODE_PRIVATE).edit();
//        sp.putString("email",null);
//        sp.putString("pass",null);
//        sp.apply();
//        Intent intent=new Intent(this,LoginActivity.class);
//        startActivity(intent);
//        finish();
        Common.setSharedPreference(this,null,null);
        Common.startSomeActivity(this,LoginActivity.class);
    }




}