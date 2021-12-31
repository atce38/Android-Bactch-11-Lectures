package com.abidingtech.www.androidbactch11.Lecture8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.abidingtech.www.androidbactch11.Common.Common;
import com.abidingtech.www.androidbactch11.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences loginShared=getSharedPreferences("login",MODE_PRIVATE);
        String e_mail=loginShared.getString("email",null);
        if(e_mail !=null) {
            startHome();
        }
        EditText edtEmail=findViewById(R.id.edtEmail);
        EditText edtPass=findViewById(R.id.pass);
        Button btnLogin=findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=edtEmail.getText().toString();
                String pass=edtPass.getText().toString();

                login(email,pass);

            }
        });

    }

    private void startHome() {
        Common.startSomeActivity(this,HomeActivity.class);
    }

    private void login(String email, String pass) {
//        SharedPreferences.Editor sp=getSharedPreferences("login",MODE_PRIVATE).edit();
//        sp.putString("email",email);
//        sp.putString("pass",pass);
//        sp.apply();
        Common.setSharedPreference(this,email,pass);
        startHome();
    }
}