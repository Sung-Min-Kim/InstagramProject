package com.example.sungminkim.instagramproject.ui.noti;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sungminkim.instagramproject.R;
import com.example.sungminkim.instagramproject.ui.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

public class NotiFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_noti, container, false);
    }

    @Override
    protected void initializeToolbar(Toolbar toolbar) {
        super.initializeToolbar(toolbar);
        toolbar.setTitle(R.string.noti_title);
    }
}
