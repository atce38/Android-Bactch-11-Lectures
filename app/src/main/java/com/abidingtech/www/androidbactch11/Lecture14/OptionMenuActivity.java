package com.abidingtech.www.androidbactch11.Lecture14;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.abidingtech.www.androidbactch11.R;

public class OptionMenuActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);

        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        Button submit=findViewById(R.id.submit);
        RadioGroup radioGrp=findViewById(R.id.radioGrp);
        Switch sw=findViewById(R.id.Switch);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Please Wait...");
                progressDialog.show();
                SystemClock.sleep(3000);

                int id=radioGrp.getCheckedRadioButtonId();
                RadioButton radioButton=findViewById(id);

                StringBuilder builder=new StringBuilder();
                builder.append(radioButton.getText().toString());


                CheckBox chkBio=findViewById(R.id.chkBio);
                chkBio.setChecked(true);
                CheckBox chkChem=findViewById(R.id.chkChem);
                if(chkBio.isChecked())
                    builder.append("\n"+chkBio.getText().toString());
                if(chkChem.isChecked())
                    builder.append("\n"+chkChem.getText().toString());
                if (sw.isChecked())
                    builder.append("\n"+sw.getTextOn().toString());
                else
                    builder.append("\n"+sw.getTextOff().toString());



                progressDialog.dismiss();
                Toast.makeText(OptionMenuActivity.this, ""+builder.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
//        Toast.makeText(OptionMenuActivity.this, ""+item.getItemId(), Toast.LENGTH_SHORT).show();
        switch (id){
            case R.id.item1:
                Toast.makeText(OptionMenuActivity.this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(OptionMenuActivity.this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

        }
         return super.onOptionsItemSelected(item);
    }
}