package com.example.sungminkim.instagramproject.data.network.api;

import com.example.sungminkim.instagramproject.data.entity.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubService {

    @GET("users")
    Call<List<User>> listUsers();
}