package com.abidingtech.www.androidbactch11.Lecture21.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.abidingtech.www.androidbactch11.Lecture21.NavActivity;
import com.abidingtech.www.androidbactch11.Lecture22.PostApi;
import com.abidingtech.www.androidbactch11.Lecture22.model.Post;
import com.abidingtech.www.androidbactch11.MainActivity;
import com.abidingtech.www.androidbactch11.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {


    TextView txtResponse;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        txtResponse=view.findViewById(R.id.txtResponse);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi=retrofit.create(PostApi.class);
        Call<Post> call=postApi.getPost(2);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    txtResponse.setText("Code: "+response.code());
                    return;
                }
                Post post=response.body();
                String resp="";
                    resp +="ID: "+post.getId()+"\n";
                    resp +="UserID: "+post.getUserId()+"\n";
                    resp +="Title : "+post.getTitle()+"\n";
                    resp +="Body: "+post.getBody()+"\n";

                    txtResponse.append(resp);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
//        Call<List<Post>> call=postApi.getPosts();

//        call.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//
//                if (!response.isSuccessful()) {
//                    txtResponse.setText("Code: "+response.code());
//                    return;
//                }
//                List<Post> posts=response.body();
//                for (Post post:posts){
//                    String resp="";
//                    resp +="ID: "+post.getId()+"\n";
//                    resp +="UserID: "+post.getUserId()+"\n";
//                    resp +="Title : "+post.getTitle()+"\n";
//                    resp +="Body: "+post.getBody()+"\n";
//
//                    txtResponse.append(resp);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                Toast.makeText(getActivity(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });


//        NavActivity.setNavItemChecked(R.id.item1);
//        getActivity().setTitle("Home");
        return view;
    }
}