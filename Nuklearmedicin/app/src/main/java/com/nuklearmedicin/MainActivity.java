package com.nuklearmedicin;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.nuklearmedicin.fragments.AfterFragment;
import com.nuklearmedicin.fragments.BeforeFragment;
import com.nuklearmedicin.fragments.ContactFragment;
import com.nuklearmedicin.fragments.DuringFragment;
import com.nuklearmedicin.fragments.MainFragment;
import com.nuklearmedicin.fragments.RestrictionFragment;
import com.nuklearmedicin.fragments.SettingsFragment;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /* Set the starting page of the application (main fragment) */
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, new MainFragment()).commit();

        /* Hide the title on the action bar */
        getSupportActionBar().setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);


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
        FragmentManager fm = getSupportFragmentManager();
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fm.beginTransaction().replace(R.id.content_frame, new MainFragment()).commit();
        } else if (id == R.id.nav_rest) {
            fm.beginTransaction().replace(R.id.content_frame, new RestrictionFragment()).commit();
        } else if (id == R.id.nav_contact) {
            fm.beginTransaction().replace(R.id.content_frame, new ContactFragment()).commit();
        } else if (id == R.id.nav_settings) {
            fm.beginTransaction().replace(R.id.content_frame, new SettingsFragment()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /* handle button clicks from main fragment */
    public void mainFragmentButtonClick(View view) {
        FragmentManager fm = getSupportFragmentManager();

        switch(view.getId()) {
            case R.id.buttonBefore:
                fm.beginTransaction().replace(R.id.content_frame, new BeforeFragment()).commit();
                break;
            case R.id.buttonDuring:
                fm.beginTransaction().replace(R.id.content_frame, new DuringFragment()).commit();
                break;
            case R.id.buttonAfter:
                fm.beginTransaction().replace(R.id.content_frame, new AfterFragment()).commit();
                break;
        }
    }

    /* handle button clicks from after fragment */
    public void toggle_contents(View v){
        switch(v.getId()){
            case R.id.rest_1:
                TextView rest_1_content = (TextView) findViewById(R.id.rest_1_content);
                if(rest_1_content.isShown()){
                    slide_up(this, rest_1_content);
                    rest_1_content.setVisibility(View.GONE);
                }
                else{
                    rest_1_content.setVisibility(View.VISIBLE);
                    slide_down(this, rest_1_content);
                }
                /*rest_1_content.setVisibility(rest_1_content.isShown() ? View.GONE : View.VISIBLE);*/
                break;
            case R.id.rest_2:
                TextView rest_2_content = (TextView) findViewById(R.id.rest_2_content);
                if(rest_2_content.isShown()){
                    slide_up(this, rest_2_content);
                    rest_2_content.setVisibility(View.GONE);
                }
                else{
                    rest_2_content.setVisibility(View.VISIBLE);
                    slide_down(this, rest_2_content);
                }
                break;
            /* TODO : fix rest of button presses */
            /*case R.id.rest_3:
                break;
            case R.id.rest_4:
                break;*/
        }

    }

    /* slide down animation for after fragment */
    public static void slide_down(Context ctx, View v){
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
        if(a != null){
            a.reset();
            if(v != null){
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }

    /* slide up animation for after fragment */
    public static void slide_up(Context ctx, View v){
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_up);
        if(a != null){
            a.reset();
            if(v != null){
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }
}
