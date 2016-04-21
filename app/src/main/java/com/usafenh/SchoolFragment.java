package com.usafenh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SchoolFragment extends Fragment {
    private static final String TAG = "SchoolFragment";
    private MainActivity mainActivity;

    public static SchoolFragment newInstance() {
        SchoolFragment fragment = new SchoolFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        mainActivity = (MainActivity)getActivity();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");
        View v = inflater.inflate(R.layout.fragment_school, container, false);

        setButtonListeners(v);

        return v;
    }

    private void setButtonListeners(View view) {
        Log.d(TAG, "setButtonListeners() called");

        (view.findViewById(R.id.UNH_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadHelpActivity(ConstantValues.SCHOOL_UNH);
            }
        });

        (view.findViewById(R.id.Keene_State)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadHelpActivity(ConstantValues.SCHOOL_KEENE_STATE);
            }
        });

        (view.findViewById(R.id.Saint_Anselm)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadHelpActivity(ConstantValues.SCHOOL_SAINT_ANSELM);
            }
        });

        (view.findViewById(R.id.White_Mountain)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadHelpActivity(ConstantValues.SCHOOL_WHITE_MOUNTAIN);
            }
        });
    }

    // Currently using buttonResourceID to have something to determine which button was pressed.
    public void loadHelpActivity(int buttonResourceID) {
        Log.d(TAG, "loadHelpActivity() called");

        mainActivity.getUserData().setSchoolID(buttonResourceID);

        mainActivity.goToHelpFragment();
    }

}
