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
                loadHelpActivity(ConstantValues.SCHOOL_UNH);
            }
        });

        (findViewById(R.id.Keene_State)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadHelpActivity(ConstantValues.SCHOOL_KEENE_STATE);
            }
        });

        (findViewById(R.id.Plymouth_State)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadHelpActivity(ConstantValues.SCHOOL_PLYMOUTH_STATE);
            }
        });

        (findViewById(R.id.Saint_Anselm)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadHelpActivity(ConstantValues.SCHOOL_SAINT_ANSELM);
            }
        });

        (findViewById(R.id.White_Mountain)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                loadHelpActivity(ConstantValues.SCHOOL_WHITE_MOUNTAIN);
            }
        });
    }

    // Currently using buttonResourceID to have something to determine which button was pressed.
    public void loadHelpActivity(int buttonResourceID) {
        Log.d(TAG, "loadTestActivity() called");
        Intent intent = new Intent(this, HelpActivity.class);

        intent.putExtra(ConstantValues.SCHOOL_TOKEN, buttonResourceID);

        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
