package com.usafenh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class UserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent myIntent = getIntent(); // gets the previously created intent
        //TODO: Set the action bar to have the school name
//        getActionBar().setTitle(myIntent.getIntExtra("schoolResourceID", 0));
    }
}
