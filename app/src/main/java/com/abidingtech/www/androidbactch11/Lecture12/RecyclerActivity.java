package com.abidingtech.www.androidbactch11.Lecture12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.abidingtech.www.androidbactch11.Lecture12.Model.Employee;
import com.abidingtech.www.androidbactch11.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        RecyclerView recycler=findViewById(R.id.recycler);
//        RecyclerView.LayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager manager=new GridLayoutManager(this,2);
        recycler.setLayoutManager(manager);
        recycler.setHasFixedSize(true);
        List<Employee> employeeList=new ArrayList<>();
        String[] img={"https://upload.wikimedia.org/wikipedia/commons/6/63/Icon_Bird_512x512.png",
                "https://image.shutterstock.com/image-vector/woman-icon-vector-fat-design-260nw-724323535.jpg",
                "https://thumbs.dreamstime.com/b/imagination-girl-kiss-lion-love-nature-abstract-concept-young-steals-male-wildlife-children-like-to-imagine-play-129595579.jpg",
                "https://www.diocesecpa.org/blog/wp-content/uploads/2019/07/Focus.jpg",
                "https://media.gettyimages.com/photos/shah-faisal-masjid-islamabad-pakistan-picture-id912853916?s=612x612"};
        for (int i=0;i<5;i++)
            employeeList.add(new Employee("emp_name"+i,img[i]));
        EmployeeAdapter adapter=new EmployeeAdapter(employeeList,this);
        recycler.setAdapter(adapter);
    }
}