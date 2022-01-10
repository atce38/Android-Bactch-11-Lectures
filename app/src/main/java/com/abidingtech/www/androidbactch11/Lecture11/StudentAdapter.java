package com.abidingtech.www.androidbactch11.Lecture11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.abidingtech.www.androidbactch11.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    ArrayList<Student> students;
    Context context;

    public StudentAdapter(ArrayList<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.list_item,parent,false);
        TextView txtlistText=view.findViewById(R.id.txtlistText);
        txtlistText.setText(students.get(position).name);
        ImageView studentimg=view.findViewById(R.id.studentimg);
        Picasso.get().load(students.get(position).img).into(studentimg);
        return view;
    }
}
