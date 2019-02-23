package ca.utoronto.shawnhu.linkedout;

//import android.app.FragmentManager;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.view.View;

import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBar;

import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//
//            final ActionBar actionBar = getSupportActionBar();
//            actionBar.setDisplayHomeAsUpEnabled(false);
//            actionBar.setTitle(null);
//
//            compactCalendar = (CompactCalendarView) findViewById(R.id.ompactableCalendar_view);
//            compactCalendar.setUseThreeLetterAbbreviation(true);
//
//            //Set an event for Teachers' Professional Day 2016 which is 21st of October
//
//            Event ev1 = new Event(Color.RED, 1477040400000L, "Teachers' Professional Day");
//            compactCalendar.addEvent(ev1);
//
//            compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
//                @Override
//                public void onDayClick(Date dateClicked) {
//                    Context context = getApplicationContext();
//
//                    if (dateClicked.toString().compareTo("Fri Oct 21 00:00:00 AST 2016") == 0) {
//                        Toast.makeText(context, "Teachers' Professional Day", Toast.LENGTH_SHORT).show();
//                    }else {
//                        Toast.makeText(context, "No Events Planned for that day", Toast.LENGTH_SHORT).show();
//                    }
//
//
//                }
//
//                @Override
//                public void onMonthScroll(Date firstDayOfNewMonth) {
//                    actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
//                }
//            });
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {
            map f1 = new map();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main_screen, f1).commit();

        } else if (id == R.id.nav_manage) {
            Calendar_Main f1 = new Calendar_Main();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main_screen, f1).commit();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());


}
