package com.usafenh;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class HelpActivity extends MainActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = "HelpActivity";

    private UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Intent myIntent = getIntent(); // gets the previously created intent
        userData = new UserData();
        // Retrieve the school id from the intent
        userData.setSchoolID(myIntent.getIntExtra(ConstantValues.SCHOOL_TOKEN, 0));

        //TODO: Set the action bar to have the school name
        setTitle(userData.getSchoolID());

        setButtonListeners();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setButtonListeners() {
        Log.d(TAG, "setButtonListeners() called");

        (findViewById(R.id.Crisis_centers)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadInfoPopup(ConstantValues.CRISIS_CENTERS);
            }
        });

        (findViewById(R.id.Local_police)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadInfoPopup(ConstantValues.LOCAL_POLICE);
            }
        });

        (findViewById(R.id.Local_hospital)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadInfoPopup(ConstantValues.LOCAL_HOSPITAL);
            }
        });

        (findViewById(R.id.Campus_resources)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadInfoPopup(ConstantValues.CAMPUS_RESOURCES);
            }
        });
    }

    // Currently using buttonResourceID to have something to determine which button was pressed.
    public void loadInfoPopup(int buttonResourceID) {
        Log.d(TAG, "loadInfoPopup() called");

        userData.setHelpType(buttonResourceID);

        final Dialog infoDialog = new Dialog(this);

        infoDialog.setContentView(R.layout.info_popup);
        infoDialog.setTitle(userData.getHelpType());

        Log.d(TAG, "Info Resource: " + ConstantValues.getInfoReference(userData));
        ((TextView) infoDialog.findViewById(R.id.info_textView)).setText(ConstantValues.getInfoReference(userData));

        ((Button) infoDialog.findViewById(R.id.cancel_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoDialog.dismiss();
            }
        });

        infoDialog.show();
    }

    public void loadFAQActivity() {
        Intent intent = new Intent(this, FAQActivity.class);

        intent.putExtra(ConstantValues.SCHOOL_TOKEN, userData.getSchoolID());

        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);
    }
}
