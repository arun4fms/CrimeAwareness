package com.example.subhankar29.crimeawareness;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.subhankar29.crimeawareness.drawer.map.MapFragment;
import com.example.subhankar29.crimeawareness.drawer.report.SubmitReport;
import com.example.subhankar29.crimeawareness.drawer.report_list.ReportListFragment;

public class MainScreenActivity extends FragmentActivity
        implements NavigationView.OnNavigationItemSelectedListener, SubmitReport.OnFragmentInteractionListener, MapFragment.OnFragmentInteractionListener, ReportListFragment.OnFragmentInteractionListener {

    FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View nav=navigationView.getHeaderView(0);

        //Initialize Fragment Manager
        manager = getSupportFragmentManager();

        //Set SubmitReport as default
        navigationView.getMenu().getItem(0).setChecked(true);

        SubmitReport submitReportFragment = new SubmitReport();
        manager.beginTransaction().replace(R.id.content_main_screen,submitReportFragment).commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);



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
        getMenuInflater().inflate(R.menu.main_screen, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_sub_report) {
            SubmitReport submitReportFragment = new SubmitReport();
            manager.beginTransaction().replace(R.id.content_main_screen,submitReportFragment).commit();

        } else if (id == R.id.nav_map) {
//            startActivity(new Intent(MainScreenActivity.this,MapFragment.class));
            MapFragment mapFragment = new MapFragment();
            manager.beginTransaction().replace(R.id.content_main_screen,mapFragment).commit();

        } else if (id == R.id.nav_report_list) {
            ReportListFragment reportListFragment = new ReportListFragment();
            manager.beginTransaction().replace(R.id.content_main_screen,reportListFragment).commit();

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
