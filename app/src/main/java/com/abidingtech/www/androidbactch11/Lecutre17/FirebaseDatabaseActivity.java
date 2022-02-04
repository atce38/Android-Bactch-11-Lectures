package com.abidingtech.www.androidbactch11.Lecutre17;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.abidingtech.www.androidbactch11.Lecture15.Book;
import com.abidingtech.www.androidbactch11.Lecture18.LoginActivity;
import com.abidingtech.www.androidbactch11.Lecture18.RegisterActivity;
import com.abidingtech.www.androidbactch11.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseDatabaseActivity extends AppCompatActivity {

//    TextView txtName;
    EditText edtTitle,edtEdition;
    Button btnSave,btnLogout;
    List<Book> bookList=new ArrayList<>();
    boolean isUpdate=false;
    String key;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_database);

        btnLogout=findViewById(R.id.btnLogout);
        edtTitle=findViewById(R.id.edtTitle);
        edtEdition=findViewById(R.id.edtEdition);
        btnSave=findViewById(R.id.btnSave);
        ListView FList=findViewById(R.id.FList);
        auth=FirebaseAuth.getInstance();
        if(auth.getCurrentUser() ==null)
            btnLogout.setVisibility(View.GONE);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Intent intent=new Intent(FirebaseDatabaseActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        DatabaseReference db= FirebaseDatabase.getInstance().getReference();
//        Save Single Value
        db.child("Students").child("name").setValue("Hassan");

        db.child("Students").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name=snapshot.child("name").getValue(String.class);
                Log.e("Value",name+"");
//                txtName.setText(name);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=edtTitle.getText().toString();
                String edittion=edtEdition.getText().toString();
//                db.push().child("name").setValue(name);
                edtTitle.setText("");
                edtEdition.setText("");

                Book book = new Book();
                book.setTitle(title);
                book.setEdition(edittion);
                if (!isUpdate)
//                        Save Object in Firebase Database
                {

                    db.child("Books").push().setValue(book);
                }else {
                    db.child("Books").child(key).setValue(book);
//                    Map<String,Object> data=new HashMap<>();
//                    data.put("title",title);
//                    data.put("edition",edittion);
//                    db.child("Books").child(key).updateChildren(data);

                }
            }
        });
        FirebaseListAdapter adapter=new FirebaseListAdapter(bookList,this);
        FList.setAdapter(adapter);
        db.child("Books").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                bookList.clear();
                for (DataSnapshot ds:snapshot.getChildren()){
                    Book book=new Book();
                    book.setKey(ds.getKey());
                    book.setTitle(ds.child("title").getValue(String.class));
                    book.setEdition(ds.child("edition").getValue(String.class));
                    bookList.add(book);
                    adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });
        FList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtTitle.setText(bookList.get(i).getTitle());
                edtEdition.setText(bookList.get(i).getEdition());
                isUpdate=true;
                key=bookList.get(i).getKey();
            }
        });
        FList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                db.child("Books")
                        .child(bookList.get(i).getKey())
                        .removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(FirebaseDatabaseActivity.this, "Data Deleted Successfully!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(FirebaseDatabaseActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
                return true;
            }
        });



    }
}