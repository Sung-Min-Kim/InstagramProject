package com.example.sungminkim.instagramproject.ui.feed;

import android.view.ViewGroup;

import com.example.sungminkim.instagramproject.ui.base.BaseRecyclerViewAdapter;
import com.example.sungminkim.instagramproject.ui.base.BaseViewHolder;

public class FeedAdapter extends BaseRecyclerViewAdapter {

    private final String TAG = getClass().getSimpleName();

    @Override
    protected BaseViewHolder getViewHolder(int viewType, ViewGroup parent) {
        return new FeedItemViewHolder(parent);
    }
}