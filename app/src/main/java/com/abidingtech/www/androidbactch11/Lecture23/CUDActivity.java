package com.abidingtech.www.androidbactch11.Lecture23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.abidingtech.www.androidbactch11.Lecture22.PostApi;
import com.abidingtech.www.androidbactch11.Lecture22.model.Post;
import com.abidingtech.www.androidbactch11.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CUDActivity extends AppCompatActivity {

    TextView txtResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cudactivity);
        txtResponse=findViewById(R.id.txtResponse);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostApi postApi=retrofit.create(PostApi.class);
        Post post=new Post();
        post.setBody("This is Some Body Text");
//        post.setTitle("This is Title");
        post.setUserId(3);

//        Following Call is used as POST METHOD
//        Call<Post> call=postApi.createPost(post);
//        Following Call is used as PUT METHOD
//        Call<Post> call=postApi.updatePost(12,post);
//        Following Call is used as PATCH METHOD
//        Call<Post> call=postApi.updatePPost(12,post);
        //        Following Call is used as PATCH METHOD
//        Call<Post> call=postApi.updatePPost(12,post);
//        call.enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//
//                if (!response.isSuccessful()) {
//                    txtResponse.setText("Code: "+response.code());
//                    return;
//                }
//                Post post=response.body();
//                String resp="";
//                resp +="ID: "+post.getId()+"\n";
//                resp +="UserID: "+post.getUserId()+"\n";
//                resp +="Title : "+post.getTitle()+"\n";
//                resp +="Body: "+post.getBody()+"\n";
//
//                txtResponse.append(resp);
//
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//
//            }
//        });

        Call<Void> call=postApi.deletePost(12);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                    txtResponse.setText("Code: "+response.code());

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

    }
}