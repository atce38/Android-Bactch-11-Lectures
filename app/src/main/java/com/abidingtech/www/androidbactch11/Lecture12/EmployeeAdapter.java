package com.abidingtech.www.androidbactch11.Lecture12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abidingtech.www.androidbactch11.Lecture12.Model.Employee;
import com.abidingtech.www.androidbactch11.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {
    List<Employee> employeeList;
    Context context;

    public EmployeeAdapter(List<Employee> employeeList, Context context) {
        this.employeeList = employeeList;
        this.context = context;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee=employeeList.get(position);
        holder.txtlistText.setText(employee.name);
        Picasso.get().load(employee.img).into(holder.studentimg);

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}
