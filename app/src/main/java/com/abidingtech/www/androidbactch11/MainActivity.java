package com.abidingtech.www.androidbactch11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView hassan=findViewById(R.id.txtHassan);
        hassan.setText("New Hassan Afzal");

    }
    void abc(){

    }
}