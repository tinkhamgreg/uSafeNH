package com.usafenh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.UUID;

public class MainActivity extends FragmentActivity
    implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    private FragmentManager fragmentMgr;
    private SchoolFragment schoolFragment;
    private HelpFragment helpFragment;

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
            setFragment(getSchoolFragment());
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

    public Fragment getSchoolFragment() {
        schoolFragment = SchoolFragment.newInstance().newInstance();
        return schoolFragment;
    }

    public Fragment getHelpFragment() {
        helpFragment = HelpFragment.newInstance().newInstance();
        return helpFragment;
    }

    public void setFragment(Fragment newFragment) {
        Log.d(TAG, "setFragment() called");

        fragmentMgr.beginTransaction()
                .add(R.id.fragment_container, newFragment)
                .addToBackStack(null)
                .commit();
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_school_selection) {
            setFragment(getSchoolFragment());
        } else if (id == R.id.nav_school_resources) {
            if (userData.getSchoolID() > 0) {
                setFragment(getHelpFragment());
            }
        } else if (id == R.id.nav_faq) {

        }  else if (id == R.id.nav_help_now) {

        } else if (id == R.id.nav_exit) {
            AppExit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
