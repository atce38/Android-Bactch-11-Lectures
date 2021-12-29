package com.abidingtech.www.androidbactch11.Lecture6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.abidingtech.www.androidbactch11.R;

public class LinearLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        TextView textView=findViewById(R.id.data);

        Intent intent=getIntent();

        String name=intent.getStringExtra("name");
        int age=intent.getIntExtra("age",0);
        textView.setText("Name:"+name+"\nAge:"+age);


    }
}