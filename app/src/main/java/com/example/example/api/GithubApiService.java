package com.example.example.api;

import com.example.example.model.githubmodel.GithubResponse;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubApiService {
//    @GET("/users/{username}/repos")
//    Observable<List<GithubResponse>> getGithubData(@Path("username") String username);
    @GET("/users/{username}/repos")
    Single<List<GithubResponse>> getGithubData(@Path("username") String username);


}
