package com.abidingtech.www.androidbactch11.Lecture15;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.abidingtech.www.androidbactch11.Lecture15.Lecture16.BookAdapter;
import com.abidingtech.www.androidbactch11.R;

import java.util.ArrayList;
import java.util.List;

public class SqliteDatabaseActivity extends AppCompatActivity {

    Button btnSave,btnView;
    EditText edtTitle,edtEdition;
    ListView list_view;
    int id;
    boolean isUpdate=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_database);

         list_view=findViewById(R.id.list_view);

        TextView txObj=findViewById(R.id.txObj);
        btnSave=findViewById(R.id.btnSave);
        btnView=findViewById(R.id.btnView);
        edtTitle=findViewById(R.id.edtTitle);
        edtEdition=findViewById(R.id.edtEdition);
        showData();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=edtTitle.getText().toString();
                String edition=edtEdition.getText().toString();
                if(!isUpdate) {
                    Book book = new Book(title, edition);
                    book.save();
                }else
                {
                    Book book = Book.findById(Book.class, id);
                    book.title=title;
                    book.edition=edition;
                    book.save();
                    isUpdate=false;
                }
                showData();
                edtTitle.setText("");
                edtEdition.setText("");
                Toast.makeText(SqliteDatabaseActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                edtTitle.setText("");
                edtEdition.setText("");
                isUpdate=false;
                id=0;
//                showData();
//                Book book = Book.findById(Book.class, 1);
//                if(book ==null)
//                    Toast.makeText(SqliteDatabaseActivity.this, "NULL", Toast.LENGTH_SHORT).show();
//                else {
//                    txObj.setText(book.title+"\n"+book.edition);
//                }
            }
        });




    }

    private void showData() {
        id=0;
        List<Book> books = Book.listAll(Book.class);
        Log.e("ListS",books.size()+"");
        BookAdapter adapter=new BookAdapter(books,SqliteDatabaseActivity.this);
        list_view.setAdapter(adapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                id=Integer.parseInt(books.get(i).getId()+"");
                isUpdate=true;
                Book book = Book.findById(Book.class, id);
                edtTitle.setText(book.getTitle());
                edtEdition.setText(book.getEdition());
                Toast.makeText(SqliteDatabaseActivity.this, ""+books.get(i).getId(), Toast.LENGTH_SHORT).show();

            }
        });
        list_view.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                id=Integer.parseInt(books.get(i).getId()+"");
                Book book = Book.findById(Book.class, id);
                book.delete();
                showData();
                return true;
            }
        });
    }
}