package com.example.example.api

import com.example.example.model.example1.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApiService {
    @GET("/posts")
    // 전체 URL 에서 EndPoint URL
    fun getData(@Query("userId") id: String?): Call<List<Post>>
}