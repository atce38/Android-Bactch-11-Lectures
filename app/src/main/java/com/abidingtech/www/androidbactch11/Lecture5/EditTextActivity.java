package com.abidingtech.www.androidbactch11.Lecture5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.abidingtech.www.androidbactch11.R;

public class EditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        TextView txtName=findViewById(R.id.txtName);
        EditText edtName=findViewById(R.id.edtName);
        Button btnName=findViewById(R.id.btnName);
        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtName.getText().toString();
                txtName.setText(name);
                edtName.setText("");
                Toast.makeText(EditTextActivity.this,""+name,Toast.LENGTH_LONG).show();
            }
        });

    }
}