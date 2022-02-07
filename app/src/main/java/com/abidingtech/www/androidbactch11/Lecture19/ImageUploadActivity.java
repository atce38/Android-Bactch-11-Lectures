package com.abidingtech.www.androidbactch11.Lecture19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.abidingtech.www.androidbactch11.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

import gun0912.tedimagepicker.builder.TedImagePicker;
import gun0912.tedimagepicker.builder.listener.OnSelectedListener;

public class ImageUploadActivity extends AppCompatActivity {

    ImageView image,secondaryImg;
    Button btnChoose,btnUpload;
    Uri imagePath;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_upload);

        image=findViewById(R.id.image);
        btnChoose=findViewById(R.id.btnChoose);
        btnUpload=findViewById(R.id.btnUpload);

        secondaryImg=findViewById(R.id.secondaryImg);
        db= FirebaseDatabase.getInstance().getReference("images");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String img=snapshot.child("img").getValue(String.class);
                if(img !=null)
                Picasso.get().load(img).into(secondaryImg);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();
            }
        });
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadImage();
            }
        });

    }

    private void uploadImage() {
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("please wait");
        progressDialog.setCancelable(false);
        progressDialog.show();
        if(imagePath !=null) {


            StorageReference storageReference = FirebaseStorage.getInstance().getReference("Images/"+ UUID.randomUUID().toString());

            storageReference.putFile(imagePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progressDialog.dismiss();
                    Toast.makeText(ImageUploadActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {

                            db.child("img").setValue(uri.toString());

                        }
                    });
                    imagePath=null;

                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                    long progress=(snapshot.getBytesTransferred()*100)/snapshot.getTotalByteCount();
                    progressDialog.setMessage(progress+"% Uploaded..");

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(ImageUploadActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }else {
            progressDialog.dismiss();
            Toast.makeText(ImageUploadActivity.this, "No Image Select", Toast.LENGTH_SHORT).show();
        }
    }

    private void chooseImage() {
        TedImagePicker.with(this)
                .start(uri -> {
                    imagePath=uri;
                    Picasso.get().load(uri).into(image);
                });

    }
}