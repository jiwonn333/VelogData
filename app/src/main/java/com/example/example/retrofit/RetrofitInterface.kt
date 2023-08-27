package com.example.example.retrofit

import retrofit2.Response

interface RetrofitInterface {
    fun onResponse(response: Response<*>?)
    fun onFailure(t: Throwable?)
}