package com.nuklearmedicin.fragments;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.nuklearmedicin.AlertReceiver;
import com.nuklearmedicin.MainActivity;
import com.nuklearmedicin.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Mikael on 2016-04-13.
 */
public class SettingsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        Switch notificationSwitch = (Switch) rootView.findViewById(R.id.switch_notifications);
        /* set listener on switch */
        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    /* turn notifications on */
                    //((MainActivity)getActivity()).readFromMemory();
                } else {
                    /* turn notifications off */
                    //((MainActivity)getActivity()).cancelAlarm();
                }
            }
        });

        return rootView;
    }
}
