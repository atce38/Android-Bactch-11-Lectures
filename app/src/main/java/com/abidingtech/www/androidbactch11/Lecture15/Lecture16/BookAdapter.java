package com.abidingtech.www.androidbactch11.Lecture15.Lecture16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.abidingtech.www.androidbactch11.Lecture15.Book;
import com.abidingtech.www.androidbactch11.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends BaseAdapter {
    List<Book> bookList;
    Context context;

    public BookAdapter(List<Book> bookList, Context context) {
        this.bookList = bookList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int i) {
        return bookList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view1=inflater.inflate(R.layout.list_item,null);
        TextView txtlistText=view1.findViewById(R.id.txtlistText);
        txtlistText.setText(bookList.get(position).getTitle()+"/Edition/"+bookList.get(position).getEdition());
        ImageView studentimg=view1.findViewById(R.id.studentimg);
        Picasso.get().load(R.drawable.ic_baseline_home_24).into(studentimg);
        return view1;
    }
}
