package com.example.sungminkim.instagramproject.data.network.helper;

import com.example.sungminkim.instagramproject.data.entity.User;
import com.example.sungminkim.instagramproject.data.network.RetrofitStore;
import com.example.sungminkim.instagramproject.data.network.api.GithubService;

import java.util.List;

import retrofit2.Callback;

public class GithubRemoteDataSource {

    private GithubService service = RetrofitStore.get().create(GithubService.class);

    public void get(Callback<List<User>> callback) {
        service.listUsers().enqueue(callback);
    }
}