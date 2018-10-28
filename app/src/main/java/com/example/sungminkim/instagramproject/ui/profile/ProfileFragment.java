package com.example.sungminkim.instagramproject.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sungminkim.instagramproject.ui.base.BaseFragment;
import com.example.sungminkim.instagramproject.R;
import com.example.sungminkim.instagramproject.ui.main.MainActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

public class ProfileFragment extends BaseFragment {

    private String name;

    public static ProfileFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString(MainActivity.NAME_KEY, name);

        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        setArguments();
        return view;
    }

    private void setArguments() {
        name = getArguments().getString(MainActivity.NAME_KEY);
    }

    @Override
    protected void initializeToolbar(Toolbar toolbar) {
        super.initializeToolbar(toolbar);
        toolbar.setTitle(name);
    }
}