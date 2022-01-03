package com.abidingtech.www.androidbactch11.Lecture9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.abidingtech.www.androidbactch11.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        ArrayList<String> students=new ArrayList<>();
        ListView listView=findViewById(R.id.listView);

        for (int i=1;i<=20;i++)
            students.add("Student "+i);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,students);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(ListActivity.this,StudentDettailActivity.class);
                intent.putExtra("s_name",students.get(position));
                startActivity(intent);

            }
        });

    }
}