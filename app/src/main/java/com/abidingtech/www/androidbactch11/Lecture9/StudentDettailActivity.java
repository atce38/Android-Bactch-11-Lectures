package com.abidingtech.www.androidbactch11.Lecture9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.abidingtech.www.androidbactch11.R;

public class StudentDettailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dettail);

        TextView txtSName=findViewById(R.id.txtSName);

        String student_name=getIntent().getStringExtra("s_name");
        txtSName.setText(student_name);
    }
}