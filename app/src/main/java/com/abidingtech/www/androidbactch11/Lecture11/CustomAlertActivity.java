package com.abidingtech.www.androidbactch11.Lecture11;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.abidingtech.www.androidbactch11.R;

public class CustomAlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_alert);

        Button btnShowDilaog=findViewById(R.id.btnShowDilaog);

        btnShowDilaog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert();
            }
        });

    }

    private void showAlert() {
        AlertDialog dialog;
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

//        LayoutInflater inflater=LayoutInflater.from(this);
//        View view=inflater.inflate(R.layout.custom_dialog,null);


        View view=LayoutInflater.from(this).inflate(R.layout.custom_dialog,null);
        Button btnNever=view.findViewById(R.id.btnNever);
        Button btnOkay=view.findViewById(R.id.btnOkay);
        builder.setView(view);

        dialog=builder.create();
        dialog.show();
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomAlertActivity.this, "Hello I m Okay Button", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        btnNever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomAlertActivity.this, "Hello I m Never Button", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

//        builder.show();
    }

}