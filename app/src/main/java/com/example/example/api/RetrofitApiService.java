package com.example.example.api;

import com.example.example.model.githubmodel.GithubResponse;
import com.example.example.model.example1.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitApiService {

    @GET("/posts")
        // 전체 URL 에서 EndPoint URL
    Call<List<Post>> getData(@Query("userId") String id);

}
