package com.abidingtech.www.androidbactch11.Lecture9;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.abidingtech.www.androidbactch11.R;

public class AlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        Button btnAlert=findViewById(R.id.btnAlert);
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert();

            }
        });

    }

    private void alert() {
        AlertDialog.Builder alert=new AlertDialog.Builder(AlertActivity.this);
        alert.setTitle("Rate US!");
        alert.setMessage("Please Rate Us!");
        alert.setIcon(R.drawable.ic_baseline_home_24);
        alert.setCancelable(false);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertActivity.this, "Thank you for rating Us", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        alert.setNegativeButton("Later",null);
        alert.show();

    }
}