package com.nuklearmedicin;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nuklearmedicin.fragments.AboutFragment;
import com.nuklearmedicin.fragments.AfterFragment;
import com.nuklearmedicin.fragments.BeforeFragment;
import com.nuklearmedicin.fragments.ContactFragment;
import com.nuklearmedicin.fragments.DuringFragment;
import com.nuklearmedicin.fragments.MainFragment;
import com.nuklearmedicin.fragments.RestrictionFragment;
import com.nuklearmedicin.fragments.SettingsFragment;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<PendingIntent> intentArray = new ArrayList<PendingIntent>();

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

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (id == R.id.nav_home) {
            navigationView.getMenu().getItem(0).setChecked(true);
            fm.beginTransaction().replace(R.id.content_frame, new MainFragment()).addToBackStack("").commit();
        } else if (id == R.id.nav_rest) {
            navigationView.getMenu().getItem(1).setChecked(true);
            fm.beginTransaction().replace(R.id.content_frame, new RestrictionFragment()).addToBackStack("").commit();
        }else if (id == R.id.nav_contact) {
            navigationView.getMenu().getItem(2).setChecked(true);
            fm.beginTransaction().replace(R.id.content_frame, new ContactFragment()).addToBackStack("").commit();
        } else if(id == R.id.nav_about) {
            navigationView.getMenu().getItem(3).setChecked(true);
            fm.beginTransaction().replace(R.id.content_frame, new AboutFragment()).addToBackStack("").commit();
        } else if (id == R.id.nav_settings) {
            navigationView.getMenu().getItem(4).setChecked(true);
            fm.beginTransaction().replace(R.id.content_frame, new SettingsFragment()).addToBackStack("").commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /* handle button clicks from main fragment */
    public void mainFragmentButtonClick(View view) {
        FragmentManager fm = getSupportFragmentManager();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        switch(view.getId()) {
            case R.id.buttonBefore:
                navigationView.getMenu().getItem(0).setChecked(false);
                fm.beginTransaction().replace(R.id.content_frame, new BeforeFragment()).addToBackStack("").commit();
                break;
            case R.id.buttonDuring:
                navigationView.getMenu().getItem(0).setChecked(false);
                fm.beginTransaction().replace(R.id.content_frame, new DuringFragment()).addToBackStack("").commit();
                break;
            case R.id.buttonAfter:
                navigationView.getMenu().getItem(0).setChecked(false);
                fm.beginTransaction().replace(R.id.content_frame, new AfterFragment()).addToBackStack("").commit();
                break;
        }
    }

    /* handle button click from restriction fragment */
    public void restrictionButtonClick (View v) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = new AfterFragment();;
        Bundle bundle = new Bundle();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        switch(v.getId()){
            case R.id.rest1:
                navigationView.getMenu().getItem(1).setChecked(false);
                bundle.putInt("rest",1);
                fragment.setArguments(bundle);
                fm.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("").commit();
                break;
            case R.id.rest2:
                navigationView.getMenu().getItem(1).setChecked(false);
                bundle.putInt("rest",2);
                fragment.setArguments(bundle);
                fm.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("").commit();
                break;
            case R.id.rest3:
                navigationView.getMenu().getItem(1).setChecked(false);
                bundle.putInt("rest",3);
                fragment.setArguments(bundle);
                fm.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("").commit();
                break;
            case R.id.rest4:
                navigationView.getMenu().getItem(1).setChecked(false);
                bundle.putInt("rest",4);
                fragment.setArguments(bundle);
                fm.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("").commit();
                break;
            case R.id.rest5:
                navigationView.getMenu().getItem(1).setChecked(false);
                bundle.putInt("rest",5);
                fragment.setArguments(bundle);
                fm.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("").commit();
                break;
            case R.id.rest6:
                navigationView.getMenu().getItem(1).setChecked(false);
                bundle.putInt("rest",6);
                fragment.setArguments(bundle);
                fm.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("").commit();
                break;
        }

    }

    /*handle button clicks from before fragment */
    public void toggle_contents2(View v){
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(DrawerLayout.LayoutParams.MATCH_PARENT, DrawerLayout.LayoutParams.MATCH_PARENT);
        Drawable arrowUp = getResources().getDrawable(R.mipmap.ic_expand_less_white_24dp);
        Drawable arrowDown = getResources().getDrawable(R.mipmap.ic_expand_more_white_24dp);
        switch(v.getId()){
            case R.id.pregnant:
                TextView pregnant_info = (TextView) findViewById(R.id.pregnant_info);
                TextView pregant = (TextView) findViewById(R.id.pregnant);

                if(pregnant_info.isShown()){
                    /* slide up animation */
                    slide_up(this, pregnant_info);
                    /* set bottom margin */
                    llp.setMargins(0,0,0,20);
                    pregant.setLayoutParams(llp);
                    /* change icon to arrow down */
                    pregant.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowDown,null);
                    /* change all corners to rounded */
                    pregant.setBackgroundResource(R.drawable.dropdown_1_round);
                    /* hide content */
                    pregnant_info.setVisibility(View.GONE);
                }
                else{
                    /* show content */
                    pregnant_info.setVisibility(View.VISIBLE);
                    /* set all margins to 0 */
                    llp.setMargins(0,0,0,0);
                    pregant.setLayoutParams(llp);
                    /* change icon to arrow up */
                    pregant.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                    /* remove two rounded corners */
                    pregant.setBackgroundResource(R.drawable.dropdown_1_edge);
                    /* slide down animation */
                    slide_down(this, pregnant_info);
                }
                break;
            case R.id.medic:
                TextView medic_info = (TextView) findViewById(R.id.medic_info);
                TextView medic = (TextView) findViewById(R.id.medic);

                if(medic_info.isShown()){
                    /* slide up animation */
                    slide_up(this, medic_info);
                    /* set bottom margin */
                    llp.setMargins(0,0,0,20);
                    medic.setLayoutParams(llp);
                    /* change icon to arrow down */
                    medic.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowDown,null);
                    /* change all corners to rounded */
                    medic.setBackgroundResource(R.drawable.dropdown_2_round);
                    /* hide content */
                    medic_info.setVisibility(View.GONE);
                }
                else{
                    /* show content */
                    medic_info.setVisibility(View.VISIBLE);
                    /* set all margins to 0 */
                    llp.setMargins(0,0,0,0);
                    medic.setLayoutParams(llp);
                    /* change icon to arrow up */
                    medic.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                    /* remove two rounded corners */
                    medic.setBackgroundResource(R.drawable.dropdown_2_edge);
                    /* slide down animation */
                    slide_down(this, medic_info);
                }
                break;
            case R.id.earlier:
                TextView earlier_info = (TextView) findViewById(R.id.earlier_info);
                TextView earlier = (TextView) findViewById(R.id.earlier);

                if(earlier_info.isShown()){
                    /* slide up animation */
                    slide_up(this, earlier_info);
                    /* set bottom margin */
                    llp.setMargins(0,0,0,20);
                    earlier.setLayoutParams(llp);
                    /* change icon to arrow down */
                    earlier.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowDown,null);
                    /* change all corners to rounded */
                    earlier.setBackgroundResource(R.drawable.dropdown_3_round);
                    /* hide content */
                    earlier_info.setVisibility(View.GONE);
                }
                else{
                    /* show content */
                    earlier_info.setVisibility(View.VISIBLE);
                    /* set all margins to 0 */
                    llp.setMargins(0,0,0,0);
                    earlier.setLayoutParams(llp);
                    /* change icon to arrow up */
                    earlier.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                    /* remove two rounded corners */
                    earlier.setBackgroundResource(R.drawable.dropdown_3_edge);
                    /* slide down animation */
                    slide_down(this, earlier_info);
                }
                break;
            case R.id.other:
                TextView other_info = (TextView) findViewById(R.id.other_info);
                TextView other = (TextView) findViewById(R.id.other);

                if(other_info.isShown()){
                    /* slide up animation */
                    slide_up(this, other_info);
                    /* set bottom margin */
                    llp.setMargins(0,0,0,20);
                    other.setLayoutParams(llp);
                    /* change icon to arrow down */
                    other.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowDown,null);
                    /* change all corners to rounded */
                    other.setBackgroundResource(R.drawable.dropdown_4_round);
                    /* hide content */
                    other_info.setVisibility(View.GONE);
                }
                else{
                    /* show content */
                    other_info.setVisibility(View.VISIBLE);
                    /* set all margins to 0 */
                    llp.setMargins(0,0,0,0);
                    other.setLayoutParams(llp);
                    /* change icon to arrow up */
                    other.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                    /* remove two rounded corners */
                    other.setBackgroundResource(R.drawable.dropdown_4_edge);
                    /* slide down animation */
                    slide_down(this, other_info);
                }
                break;
    }}

    /* handle button clicks from after fragment */
    public void toggle_contents(View v){
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(DrawerLayout.LayoutParams.MATCH_PARENT, DrawerLayout.LayoutParams.MATCH_PARENT);
        Drawable arrowUp = getResources().getDrawable(R.mipmap.ic_expand_less_white_24dp);
        Drawable arrowDown = getResources().getDrawable(R.mipmap.ic_expand_more_white_24dp);
        switch(v.getId()){
            case R.id.rest_1:
                TextView rest_1_content = (TextView) findViewById(R.id.rest_1_content);
                TextView rest_1 = (TextView) findViewById(R.id.rest_1);

                if(rest_1_content.isShown()){
                    /* slide up animation */
                    slide_up(this, rest_1_content);
                    /* set bottom margin */
                    llp.setMargins(0,0,0,20);
                    rest_1.setLayoutParams(llp);
                    /* change icon to arrow down */
                    rest_1.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowDown,null);
                    /* change all corners to rounded */
                    rest_1.setBackgroundResource(R.drawable.button_corners);
                    /* hide content */
                    rest_1_content.setVisibility(View.GONE);
                }
                else{
                    /* show content */
                    rest_1_content.setVisibility(View.VISIBLE);
                    /* set all margins to 0 */
                    llp.setMargins(0,0,0,0);
                    rest_1.setLayoutParams(llp);
                    /* change icon to arrow up */
                    rest_1.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                    /* remove two rounded corners */
                    rest_1.setBackgroundResource(R.drawable.rest_corner);
                    /* slide down animation */
                    slide_down(this, rest_1_content);
                }
                break;
            case R.id.rest_2:
                TextView rest_2_content = (TextView) findViewById(R.id.rest_2_content);
                TextView rest_2 = (TextView) findViewById(R.id.rest_2);
                if(rest_2_content.isShown()){
                    /* slide up animation */
                    slide_up(this, rest_2_content);
                    /* set bottom margin */
                    llp.setMargins(0,0,0,20);
                    rest_2.setLayoutParams(llp);
                    /* change icon to arrow down */
                    rest_2.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowDown,null);
                    /* change all corners to rounded */
                    rest_2.setBackgroundResource(R.drawable.button_corners);
                     /* hide content */
                    rest_2_content.setVisibility(View.GONE);
                }
                else{
                    /* show content */
                    rest_2_content.setVisibility(View.VISIBLE);
                    /* set all margins to 0 */
                    llp.setMargins(0,0,0,0);
                    rest_2.setLayoutParams(llp);
                    /* change icon to arrow up */
                    rest_2.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                    /* remove two rounded corners */
                    rest_2.setBackgroundResource(R.drawable.rest_corner);
                    /* slide down animation */
                    slide_down(this, rest_2_content);
                }
                break;
            /* TODO : fix rest of button presses */
            case R.id.rest_3:
                TextView rest_3_content = (TextView) findViewById(R.id.rest_3_content);
                TextView rest_3 = (TextView) findViewById(R.id.rest_3);
                if(rest_3_content.isShown()){
                    /* slide up animation */
                    slide_up(this, rest_3_content);
                    /* set bottom margin */
                    llp.setMargins(0,0,0,20);
                    rest_3.setLayoutParams(llp);
                    /* change icon to arrow down */
                    rest_3.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowDown,null);
                    /* change all corners to rounded */
                    rest_3.setBackgroundResource(R.drawable.button_corners);
                     /* hide content */
                    rest_3_content.setVisibility(View.GONE);
                }
                else{
                    /* show content */
                    rest_3_content.setVisibility(View.VISIBLE);
                    /* set all margins to 0 */
                    llp.setMargins(0,0,0,0);
                    rest_3.setLayoutParams(llp);
                    /* change icon to arrow up */
                    rest_3.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                    /* remove two rounded corners */
                    rest_3.setBackgroundResource(R.drawable.rest_corner);
                    /* slide down animation */
                    slide_down(this, rest_3_content);
                }
                break;
            case R.id.rest_4:
                TextView rest_4_content = (TextView) findViewById(R.id.rest_4_content);
                TextView rest_4 = (TextView) findViewById(R.id.rest_4);
                if(rest_4_content.isShown()){
                    /* slide up animation */
                    slide_up(this, rest_4_content);
                    /* set bottom margin */
                    llp.setMargins(0,0,0,20);
                    rest_4.setLayoutParams(llp);
                    /* change icon to arrow down */
                    rest_4.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowDown,null);
                    /* change all corners to rounded */
                    rest_4.setBackgroundResource(R.drawable.button_corners);
                     /* hide content */
                    rest_4_content.setVisibility(View.GONE);
                }
                else{
                    /* show content */
                    rest_4_content.setVisibility(View.VISIBLE);
                    /* set all margins to 0 */
                    llp.setMargins(0,0,0,0);
                    rest_4.setLayoutParams(llp);
                    /* change icon to arrow up */
                    rest_4.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                    /* remove two rounded corners */
                    rest_4.setBackgroundResource(R.drawable.rest_corner);
                    /* slide down animation */
                    slide_down(this, rest_4_content);
                }
                break;
            case R.id.rest_5:
                TextView rest_5_content = (TextView) findViewById(R.id.rest_5_content);
                TextView rest_5 = (TextView) findViewById(R.id.rest_5);
                if(rest_5_content.isShown()){
                    /* slide up animation */
                    slide_up(this, rest_5_content);
                    /* set bottom margin */
                    llp.setMargins(0,0,0,20);
                    rest_5.setLayoutParams(llp);
                    /* change icon to arrow down */
                    rest_5.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowDown,null);
                    /* change all corners to rounded */
                    rest_5.setBackgroundResource(R.drawable.button_corners);
                     /* hide content */
                    rest_5_content.setVisibility(View.GONE);
                }
                else{
                    /* show content */
                    rest_5_content.setVisibility(View.VISIBLE);
                    /* set all margins to 0 */
                    llp.setMargins(0,0,0,0);
                    rest_5.setLayoutParams(llp);
                    /* change icon to arrow up */
                    rest_5.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                    /* remove two rounded corners */
                    rest_5.setBackgroundResource(R.drawable.rest_corner);
                    /* slide down animation */
                    slide_down(this, rest_5_content);
                }
                break;
            case R.id.rest_6:
                TextView rest_6_content = (TextView) findViewById(R.id.rest_6_content);
                TextView rest_6 = (TextView) findViewById(R.id.rest_6);
                if(rest_6_content.isShown()){
                     /* slide up animation */
                    slide_up(this, rest_6_content);
                    /* set bottom margin */
                    llp.setMargins(0,0,0,20);
                    rest_6.setLayoutParams(llp);
                    /* change icon to arrow down */
                    rest_6.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowDown,null);
                    /* change all corners to rounded */
                    rest_6.setBackgroundResource(R.drawable.button_corners);
                     /* hide content */
                    rest_6_content.setVisibility(View.GONE);
                }
                else{
                     /* show content */
                    rest_6_content.setVisibility(View.VISIBLE);
                    /* set all margins to 0 */
                    llp.setMargins(0,0,0,0);
                    rest_6.setLayoutParams(llp);
                    /* change icon to arrow up */
                    rest_6.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                    /* remove two rounded corners */
                    rest_6.setBackgroundResource(R.drawable.rest_corner);
                    /* slide down animation */
                    slide_down(this, rest_6_content);
                }
                break;
        }
    }

    /* handle button clicks from during fragment */
    public void toggle_contents_3(View v){
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(DrawerLayout.LayoutParams.MATCH_PARENT, DrawerLayout.LayoutParams.MATCH_PARENT);
        Drawable arrowUp = getResources().getDrawable(R.mipmap.ic_expand_less_white_24dp);
        Drawable arrowDown = getResources().getDrawable(R.mipmap.ic_expand_more_white_24dp);
        switch(v.getId()){
            case R.id.during_1:
                TextView during_1_content = (TextView) findViewById(R.id.during_1_content);
                TextView during_1 = (TextView) findViewById(R.id.during_1);

                if(during_1_content.isShown()){
                    /* slide up animation */
                    slide_up(this, during_1_content);
                    /* set bottom margin */
                    llp.setMargins(0,0,0,20);
                    during_1.setLayoutParams(llp);
                    /* change icon to arrow down */
                    during_1.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowDown,null);
                    /* change all corners to rounded */
                    during_1.setBackgroundResource(R.drawable.button_corners);
                    /* hide content */
                    during_1_content.setVisibility(View.GONE);
                }
                else{
                    /* show content */
                    during_1_content.setVisibility(View.VISIBLE);
                    /* set all margins to 0 */
                    llp.setMargins(0,0,0,0);
                    during_1.setLayoutParams(llp);
                    /* change icon to arrow up */
                    during_1.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                    /* remove two rounded corners */
                    during_1.setBackgroundResource(R.drawable.rest_corner);
                    /* slide down animation */
                    slide_down(this, during_1_content);
                }
                break;
            case R.id.during_2:
                TextView during_2_content = (TextView) findViewById(R.id.during_2_content);
                TextView during_2 = (TextView) findViewById(R.id.during_2);
                if(during_2_content.isShown()){
                    /* slide up animation */
                    slide_up(this, during_2_content);
                    /* set bottom margin */
                    llp.setMargins(0,0,0,20);
                    during_2.setLayoutParams(llp);
                    /* change icon to arrow down */
                    during_2.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowDown,null);
                    /* change all corners to rounded */
                    during_2.setBackgroundResource(R.drawable.button_corners);
                     /* hide content */
                    during_2_content.setVisibility(View.GONE);
                }
                else{
                    /* show content */
                    during_2_content.setVisibility(View.VISIBLE);
                    /* set all margins to 0 */
                    llp.setMargins(0,0,0,0);
                    during_2.setLayoutParams(llp);
                    /* change icon to arrow up */
                    during_2.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                    /* remove two rounded corners */
                    during_2.setBackgroundResource(R.drawable.rest_corner);
                    /* slide down animation */
                    slide_down(this, during_2_content);
                }
                break;
            case R.id.during_3:
                TextView during_3_content = (TextView) findViewById(R.id.during_3_content);
                TextView during_3 = (TextView) findViewById(R.id.during_3);
                if(during_3_content.isShown()){
                    /* slide up animation */
                    slide_up(this, during_3_content);
                    /* set bottom margin */
                    llp.setMargins(0,0,0,20);
                    during_3.setLayoutParams(llp);
                    /* change icon to arrow down */
                    during_3.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowDown,null);
                    /* change all corners to rounded */
                    during_3.setBackgroundResource(R.drawable.button_corners);
                     /* hide content */
                    during_3_content.setVisibility(View.GONE);
                }
                else{
                    /* show content */
                    during_3_content.setVisibility(View.VISIBLE);
                    /* set all margins to 0 */
                    llp.setMargins(0,0,0,0);
                    during_3.setLayoutParams(llp);
                    /* change icon to arrow up */
                    during_3.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                    /* remove two rounded corners */
                    during_3.setBackgroundResource(R.drawable.rest_corner);
                    /* slide down animation */
                    slide_down(this, during_3_content);
                }
                break;
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

    public void setAlarm(Calendar targetCal, int rest){
        Calendar cal = Calendar.getInstance();
        Long currentTime = cal.getTimeInMillis();
        Long alarmTime = targetCal.getTimeInMillis();
        /* if date has already passed, don't set alarm */
        if(alarmTime < currentTime){
            return;
        }
        Intent intent = new Intent(this, AlertReceiver.class);
        intent.putExtra("rest", rest);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), PendingIntent.getBroadcast(this, rest, intent, 0));
    }
}
