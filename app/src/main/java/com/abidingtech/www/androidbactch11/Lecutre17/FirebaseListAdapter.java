package com.abidingtech.www.androidbactch11.Lecutre17;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.abidingtech.www.androidbactch11.Lecture15.Book;
import com.abidingtech.www.androidbactch11.R;

import java.util.List;

public class FirebaseListAdapter extends BaseAdapter {
    List<Book> bookList;
    Context context;

    public FirebaseListAdapter(List<Book> bookList, Context context) {
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        View item= LayoutInflater.from(context).inflate(R.layout.firebase_list_item,null);
        TextView txtTitle=item.findViewById(R.id.txtTitle);
        TextView txtEdition=item.findViewById(R.id.txtEdition);
        txtTitle.setText(bookList.get(i).getTitle());
        txtEdition.setText(bookList.get(i).getEdition());
        return item;
    }
}
