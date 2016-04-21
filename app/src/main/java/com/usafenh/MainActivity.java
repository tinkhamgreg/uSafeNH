package com.usafenh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity
    implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    private FragmentManager fragmentMgr;
    private SchoolFragment schoolFragment;
    private HelpFragment helpFragment;
    private FAQFragment faqFragment;

    private UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called");
        userData = new UserData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        fragmentMgr = getSupportFragmentManager();
        Fragment fragment = fragmentMgr.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            goToSchoolFragment();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void goToSchoolFragment() {
        schoolFragment = SchoolFragment.newInstance().newInstance();
        setFragment(schoolFragment, false);
    }

    public void goToHelpFragment() {
        helpFragment = HelpFragment.newInstance().newInstance();
        setFragment(helpFragment, true);
    }

    public void goToFAQFragment() {
        faqFragment = FAQFragment.newInstance().newInstance();
        setFragment(faqFragment, true);
    }

    public void setFragment(Fragment newFragment, boolean addToBackStack) {
        Log.d(TAG, "setFragment() called");

        FragmentTransaction transaction = fragmentMgr.beginTransaction();
        transaction.replace(R.id.fragment_container, newFragment);
        if (addToBackStack) {
            transaction.addToBackStack(newFragment.getTag());
        }

        transaction.commit();
    }

    public UserData getUserData() {
        return userData;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void AppExit()
    {

        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Log.d(TAG, "onNavigationItemSelected() called");
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_school_selection) {
            goToSchoolFragment();
        } else if (id == R.id.nav_school_resources) {
            if (userData.getSchoolID() > 0) {
                goToHelpFragment();
            } else {
                goToSchoolFragment();
                ((NavigationView) findViewById(R.id.nav_view)).getMenu().getItem(0).setChecked(true);
            }
        } else if (id == R.id.nav_faq) {
            goToFAQFragment();

        }  else if (id == R.id.nav_help_now) {

        } else if (id == R.id.nav_exit) {
            AppExit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(ConstantValues.SCHOOL_TOKEN, userData.getSchoolID());
        savedInstanceState.putInt(ConstantValues.HELP_TYPE_TOKEN, userData.getHelpType());

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        userData.setSchoolID(savedInstanceState.getInt(ConstantValues.SCHOOL_TOKEN));
        userData.setHelpType(savedInstanceState.getInt(ConstantValues.HELP_TYPE_TOKEN));
    }
}
