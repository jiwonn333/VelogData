package com.example.example.api

import com.example.example.model.githubmodel.GithubResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {
    @GET("/users/{username}/repos")
    fun getGithubData(@Path("username") username: String?): Single<List<GithubResponse>>
}