package com.example.wuyuan.clone_instagram.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.wuyuan.clone_instagram.R;
import com.example.wuyuan.clone_instagram.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class ProfileActivity extends AppCompatActivity{
    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM = 4;

    private Context mContext = ProfileActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started.");
        setupBottomNavigationView();
        setUpToolbar();
    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: navigating to account settings.");
                Intent intent = new Intent(mContext, AccountSettingActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * BottomNavigationView setup
     */
    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
