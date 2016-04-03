package com.usafenh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class HelpActivity extends Activity {

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
    }

    private void setButtonListeners() {
        Log.d(TAG, "setButtonListeners() called");

        (findViewById(R.id.Crisis_centers)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTestActivity(ConstantValues.CRISIS_CENTERS);
            }
        });

        (findViewById(R.id.Local_police)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTestActivity(ConstantValues.LOCAL_POLICE);
            }
        });

        (findViewById(R.id.Local_hospital)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTestActivity(ConstantValues.LOCAL_HOSPITAL);
            }
        });

        (findViewById(R.id.Campus_resources)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTestActivity(ConstantValues.CAMPUS_RESOURCES);
            }
        });
    }

    // Currently using buttonResourceID to have something to determine which button was pressed.
    public void loadTestActivity(int buttonResourceID) {
        //TODO: Display the correct help information.  Might just be a popup instead of a new Activity.
        Log.d(TAG, "loadTestActivity() called");
        Intent intent = new Intent(this, TestActivity.class);

        intent.putExtra(ConstantValues.SCHOOL_TOKEN, userData.getSchoolID());
        intent.putExtra(ConstantValues.HELP_TYPE_TOKEN, buttonResourceID);

        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);
    }
}
