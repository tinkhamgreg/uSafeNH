package com.usafenh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setButtonListeners();
    }

    private void setButtonListeners() {
        Log.d(TAG, "setButtonListeners() called");

        (findViewById(R.id.UNH_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadUserActivity(R.string.UNH_button);
            }
        });

        (findViewById(R.id.Keene_State)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadUserActivity(R.string.Keene_State);
            }
        });

        (findViewById(R.id.Plymouth_State)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadUserActivity(R.string.Plymouth_State);
            }
        });

        (findViewById(R.id.Saint_Anselm)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadUserActivity(R.string.Saint_Anselm);
            }
        });
    }

    // Currently using buttonResourceID to have something to determine which button was pressed.
    public void loadUserActivity(int buttonResourceID) {
        Log.d(TAG, "loadUserActivity() called");
        Intent intent = new Intent(this, UserActivity.class);

        intent.putExtra("schoolResourceID", buttonResourceID);

        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
