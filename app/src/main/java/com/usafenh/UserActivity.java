package com.usafenh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class UserActivity extends Activity {

    private static final String TAG = "UserActivity";

    private UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

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

        (findViewById(R.id.help_now_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadHelpActivity(ConstantValues.USER_SELF);
            }
        });

        (findViewById(R.id.help_someone)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadHelpActivity(ConstantValues.USER_OTHER);
            }
        });
    }

    // Currently using buttonResourceID to have something to determine which button was pressed.
    public void loadHelpActivity(int buttonResourceID) {
        Log.d(TAG, "loadHelpActivity() called");
        Intent intent = new Intent(this, HelpActivity.class);

        intent.putExtra(ConstantValues.SCHOOL_TOKEN, userData.getSchoolID());
        intent.putExtra(ConstantValues.USER_TOKEN, buttonResourceID);

        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);
    }
}
