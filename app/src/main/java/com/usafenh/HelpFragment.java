package com.usafenh;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class HelpFragment extends Fragment {

    private static final String TAG = "HelpFragment";
    private MainActivity mainActivity;

    public static HelpFragment newInstance() {
        HelpFragment fragment = new HelpFragment();
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
        View v = inflater.inflate(R.layout.fragment_help, container, false);

        setButtonListeners(v);

        return v;
    }

    private void setButtonListeners(View view) {
        Log.d(TAG, "setButtonListeners() called");

        (view.findViewById(R.id.Crisis_centers)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadInfoPopup(ConstantValues.CRISIS_CENTERS);
            }
        });

        (view.findViewById(R.id.Local_police)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadInfoPopup(ConstantValues.LOCAL_POLICE);
            }
        });

        (view.findViewById(R.id.Local_hospital)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadInfoPopup(ConstantValues.LOCAL_HOSPITAL);
            }
        });

        (view.findViewById(R.id.Campus_resources)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadInfoPopup(ConstantValues.CAMPUS_RESOURCES);
            }
        });
    }

    // Currently using buttonResourceID to have something to determine which button was pressed.
    public void loadInfoPopup(int buttonResourceID) {
        Log.d(TAG, "loadInfoPopup() called");

        mainActivity.getUserData().setHelpType(buttonResourceID);

        final Dialog infoDialog = new Dialog(mainActivity);

        infoDialog.setContentView(R.layout.info_popup);
        infoDialog.setTitle(mainActivity.getUserData().getHelpType());

        Log.d(TAG, "Info Resource: " + ConstantValues.getInfoReference(mainActivity.getUserData()));
        ((TextView) infoDialog.findViewById(R.id.info_textView)).setText(ConstantValues.getInfoReference(mainActivity.getUserData()));

        ((Button) infoDialog.findViewById(R.id.cancel_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoDialog.dismiss();
            }
        });

        infoDialog.show();
    }

    public void loadFAQActivity() {/*
        Intent intent = new Intent(this, FAQActivity.class);

        intent.putExtra(ConstantValues.SCHOOL_TOKEN, userData.getSchoolID());

        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);*/
    }
}
