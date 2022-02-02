package com.abidingtech.www.androidbactch11.Lecutre17;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.abidingtech.www.androidbactch11.Lecture15.Book;
import com.abidingtech.www.androidbactch11.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseDatabaseActivity extends AppCompatActivity {

    TextView txtName;
    EditText edtTitle,edtEdition;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_database);

        txtName=findViewById(R.id.txtName);
        edtTitle=findViewById(R.id.edtTitle);
        edtEdition=findViewById(R.id.edtEdition);
        btnSave=findViewById(R.id.btnSave);


        DatabaseReference db= FirebaseDatabase.getInstance().getReference();
//        Save Single Value
        db.child("Students").child("name").setValue("Hassan");

        db.child("Students").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name=snapshot.child("name").getValue(String.class);
                Log.e("Value",name+"");
                txtName.setText(name);

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

//                        Save Object in Firebase Database
                    Book book=new Book();
                    book.setTitle(title);
                    book.setEdition(edittion);
                    db.child("Books").push().setValue(book);
            }
        });



    }
}