package com.abidingtech.www.androidbactch11.Lecture22;

import com.abidingtech.www.androidbactch11.Lecture22.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") int id);
}
