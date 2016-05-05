package com.usafenh;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
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

        (view.findViewById(R.id.faq)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.goToFAQFragment();
            }
        });
    }

    // Currently using buttonResourceID to have something to determine which button was pressed.
    public void loadInfoPopup(int buttonResourceID) {
        Log.d(TAG, "loadInfoPopup() called");

        mainActivity.getUserData().setHelpType(buttonResourceID);

        final CustomDialog infoDialog = new CustomDialog(mainActivity);

        infoDialog.setTitle(mainActivity.getUserData().getHelpType());

        infoDialog.show();
    }

    public class CustomDialog extends Dialog
    {
        public CustomDialog(Context context) {
            super(context);
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.info_popup);

            getWindow().setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

            Log.d(TAG, "Info Resource: " + ConstantValues.getInfoReference(mainActivity.getUserData()));
            ((TextView) findViewById(R.id.info_textView)).setText(ConstantValues.getInfoReference(mainActivity.getUserData()));
            ((TextView) findViewById(R.id.help_title_textView)).setText(mainActivity.getUserData().getHelpType());

            ((Button) findViewById(R.id.cancel_button)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }
    }
}
