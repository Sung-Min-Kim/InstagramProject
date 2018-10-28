package com.example.sungminkim.instagramproject.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.sungminkim.instagramproject.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    protected final String TAG = getClass().getSimpleName();
    protected Context context;
    protected BaseActivity activity;

    private Toolbar toolbar;

    public Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeView(view);
        initializeToolbar(toolbar);
    }

    private void initialize() {
        context = getContext();
        activity = (BaseActivity) getActivity();
    }

    private void initializeView(View view) {
        toolbar = view.findViewById(R.id.toolbar);
    }

    protected void initializeToolbar(Toolbar toolbar) {
        // Do nothing
    }
}