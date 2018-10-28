package com.example.sungminkim.instagramproject.ui.main;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.sungminkim.instagramproject.ui.base.BaseActivity;
import com.example.sungminkim.instagramproject.R;
import com.example.sungminkim.instagramproject.ui.feed.FeedFragment;
import com.example.sungminkim.instagramproject.ui.noti.NotiFragment;
import com.example.sungminkim.instagramproject.ui.profile.ProfileFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends BaseActivity {

    public static final String NAME_KEY = "NAME_KEY";
    private String name;

    private Fragment feedFragment;
    private Fragment notiFragment;
    private Fragment profileFragment;
    private Fragment activeFragment;
    private final FragmentManager fm = getSupportFragmentManager();

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setArguments();
        initializeFragments();

        findView();
        setBottomNavigationView();

        bottomNavigationView.setSelectedItemId(R.id.nav_bottom_feed);
    }

    private void setArguments() {
        name = getIntent().getStringExtra(NAME_KEY);
    }

    private void initializeFragments() {
        feedFragment = new FeedFragment();
        notiFragment = new NotiFragment();
        profileFragment = ProfileFragment.newInstance(name);

        fm.beginTransaction().add(R.id.box_fragment, feedFragment).hide(feedFragment)
                .add(R.id.box_fragment, notiFragment).hide(notiFragment)
                .add(R.id.box_fragment, profileFragment).hide(profileFragment)
                .commit();
    }

    private void findView() {
        bottomNavigationView = findViewById(R.id.nav_bottom);
    }

    private void setBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_bottom_feed:
                        setFragment(feedFragment);
                        return true;
                    case R.id.nav_bottom_noti:
                        setFragment(notiFragment);
                        return true;
                    case R.id.nav_bottom_profile:
                        setFragment(profileFragment);
                        return true;
                }
                return false;
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction transaction = fm.beginTransaction();
        if (activeFragment != null) transaction.hide(activeFragment);
        transaction.show(fragment)
                .commit();
        activeFragment = fragment;
    }
}