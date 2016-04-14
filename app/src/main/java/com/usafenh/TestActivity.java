package com.usafenh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

//TODO: Convert this activity into the FAQ Activity
public class TestActivity extends MainActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = "TestActivity";

    private UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent myIntent = getIntent();
        userData = new UserData();
        userData.setSchoolID(myIntent.getIntExtra(ConstantValues.SCHOOL_TOKEN, 0));
        userData.setHelpType(myIntent.getIntExtra(ConstantValues.HELP_TYPE_TOKEN, 0));

        // TODO: Remove this line, because this is just used for debugging purposes
        ((TextView) findViewById(R.id.selected_info_text)).setText("Selected school: " +
                userData.getSchoolName(this) + "\nSelected User: " + userData.getHelpString(this));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
}
