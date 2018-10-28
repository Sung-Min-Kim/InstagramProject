package com.example.sungminkim.instagramproject.ui.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sungminkim.instagramproject.R;
import com.example.sungminkim.instagramproject.data.entity.User;
import com.example.sungminkim.instagramproject.data.network.helper.GithubRemoteDataSource;
import com.example.sungminkim.instagramproject.ui.base.BaseFragment;
import com.example.sungminkim.instagramproject.ui.view.LoadingBar;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private LoadingBar loadingBar;

    private FeedAdapter adapter;
    private GithubRemoteDataSource dataSource = new GithubRemoteDataSource();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_feed, container, false);
        findView(view);
        return view;
    }

    @Override
    protected void initializeToolbar(Toolbar toolbar) {
        super.initializeToolbar(toolbar);
        toolbar.setTitle(R.string.feed_title);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRecyclerView();
        loadItems();
    }

    private void findView(View view) {
        recyclerView = view.findViewById(R.id.recyclerview);
        loadingBar = view.findViewById(R.id.loading);
    }

    private void setRecyclerView() {
        adapter = new FeedAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }

    private void loadItems() {
        loadingBar.show();
        dataSource.get(new Callback<List<User>>() {

            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                loadingBar.hide();
                adapter.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                loadingBar.hide();
                t.printStackTrace();
            }
        });
    }
}