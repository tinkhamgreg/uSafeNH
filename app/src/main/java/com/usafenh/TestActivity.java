package com.usafenh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

//TODO: Convert this activity into the FAQ Activity
public class TestActivity extends Activity {

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
    }
}
