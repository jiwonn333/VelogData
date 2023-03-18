package com.example.example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApiService {

    String BASE_URL = "http://jsonplaceholder.typicode.com";

    @GET("/posts") // 전체 URL 에서 EndPoint URL
    Call<List<Post>> getData(@Query("userId") String id);
}
