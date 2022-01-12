package com.abidingtech.www.androidbactch11.Lecture12;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abidingtech.www.androidbactch11.R;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    public ImageView studentimg;
    public TextView txtlistText;
    public EmployeeViewHolder(@NonNull View itemView) {
        super(itemView);
        studentimg=itemView.findViewById(R.id.studentimg);
        txtlistText=itemView.findViewById(R.id.txtlistText);
    }
}
