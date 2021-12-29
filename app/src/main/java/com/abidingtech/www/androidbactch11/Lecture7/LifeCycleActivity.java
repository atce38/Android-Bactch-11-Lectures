package com.abidingtech.www.androidbactch11.Lecture7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.abidingtech.www.androidbactch11.Lecture6.LinearLayoutActivity;
import com.abidingtech.www.androidbactch11.R;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.e("onCreate","================");
        Button btnStart=findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LifeCycleActivity.this, LinearLayoutActivity.class);
                intent.putExtra("name","Hassan");
                intent.putExtra("age",23);
                startActivity(intent);
//                finish();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(LifeCycleActivity.this, "I m onStart", Toast.LENGTH_SHORT).show();
        Log.e("onStart","================");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(LifeCycleActivity.this, "I m onResume", Toast.LENGTH_SHORT).show();
        Log.e("onResume","================");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(LifeCycleActivity.this, "I m onRestart", Toast.LENGTH_SHORT).show();
        Log.e("onRestart","================");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(LifeCycleActivity.this, "I m onPause", Toast.LENGTH_SHORT).show();
        Log.e("onPause","================");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(LifeCycleActivity.this, "I m onStop", Toast.LENGTH_SHORT).show();
        Log.e("onStop","================");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(LifeCycleActivity.this, "I m onDestroy", Toast.LENGTH_SHORT).show();
        Log.e("onDestroy","================");
    }
}