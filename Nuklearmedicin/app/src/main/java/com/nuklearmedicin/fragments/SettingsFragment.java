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
                    readFromMemory(rootView);
                    ((MainActivity)getActivity()).setAlarm(cal1, 1);
                    ((MainActivity)getActivity()).setAlarm(cal2, 2);
                    ((MainActivity)getActivity()).setAlarm(cal3, 3);
                    ((MainActivity)getActivity()).setAlarm(cal4, 4);
                    ((MainActivity)getActivity()).setAlarm(cal5, 5);
                    ((MainActivity)getActivity()).setAlarm(cal6, 6);
                } else {
                    /* turn notifications off */
                    cancelAlarm();
                }
            }
        });

        return rootView;
    }

    public void cancelAlarm(){
        Intent intent = new Intent(getContext(), AlertReceiver.class);
        PendingIntent pendingIntent;
        AlarmManager alarmManager = (AlarmManager)getActivity().getSystemService(Context.ALARM_SERVICE);
        for(int i = 1; i < 7; i++) {
            pendingIntent = PendingIntent.getBroadcast(getContext(), i, intent, 0);
            alarmManager.cancel(pendingIntent);
        }
    }

    /* open file from phone memory and get user code if present */
    public void readFromMemory(View root){
        try {
            String code;
            FileInputStream fileInputStream = getContext().openFileInput("user_code");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while((code = bufferedReader.readLine()) != null){
                stringBuffer.append(code + "\n");
            }

            /* parse the code and display in textviews */
            parseUserInput(stringBuffer.toString(), root);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    Calendar cal3 = Calendar.getInstance();
    Calendar cal4 = Calendar.getInstance();
    Calendar cal5 = Calendar.getInstance();
    Calendar cal6 = Calendar.getInstance();

    /* parse the user input and display in textviews */
    public void parseUserInput(String input, View root) {
        int date, month, rest1, rest2, rest3, rest4, rest5, rest6, i;
        String r1="", r2="", r3="", r4="", r5="", r6="";
        int[] restArray = new int[input.length()];
        int j = input.length();

        for(i = 0; i < j; i++) {
            try {
                restArray[i] = Integer.parseInt(String.valueOf(input.charAt(i)), 36);
            }  catch (NumberFormatException n){}
        }

        date = restArray[0];
        month = restArray[1];
        rest1 = restArray[2];
        rest2 = restArray[3];
        rest3 = restArray[4];
        rest4 = restArray[5];
        rest5 = restArray[6];
        rest6 = restArray[7];

        SimpleDateFormat day = new SimpleDateFormat("dd");
        SimpleDateFormat mon = new SimpleDateFormat("MM");
        SimpleDateFormat year = new SimpleDateFormat("yy");

        Calendar cal = Calendar.getInstance();
        Long currentDate = cal.getTimeInMillis();
        Long rest1Date = cal.getTimeInMillis(), rest2Date = cal.getTimeInMillis(),
                rest3Date = cal.getTimeInMillis(), rest4Date = cal.getTimeInMillis(),
                rest5Date = cal.getTimeInMillis(), rest6Date = cal.getTimeInMillis();

        /*cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));*/

        for(i = 0; i < 6; i++){
            switch (i){
                case 0:
                    cal1.set(Calendar.DAY_OF_MONTH, date);
                    cal1.set(Calendar.MONTH, month-1);
                    cal1.set(Calendar.HOUR_OF_DAY, 11);
                    cal1.set(Calendar.MINUTE, 55);
                    cal1.add(Calendar.DATE, rest1);
                    rest1Date = cal1.getTimeInMillis();
                    r1 = day.format(cal1.getTime()).replaceFirst("^0+(?!$)", "");
                    r1 += "/" + mon.format(cal1.getTime()).replaceFirst("^0+(?!$)", "");
                    r1 += "-" + year.format(cal1.getTime()).replaceFirst("^0+(?!$)", "");
                    break;
                case 1:
                    cal2.set(Calendar.DAY_OF_MONTH, date);
                    cal2.set(Calendar.MONTH, month-1);
                    cal2.set(Calendar.HOUR_OF_DAY, 11);
                    cal2.set(Calendar.MINUTE, 55);
                    cal2.add(Calendar.DATE, rest2);
                    rest2Date = cal2.getTimeInMillis();
                    r2 = day.format(cal2.getTime()).replaceFirst("^0+(?!$)", "");
                    r2 += "/" + mon.format(cal2.getTime()).replaceFirst("^0+(?!$)", "");
                    r2 += "-" + year.format(cal2.getTime()).replaceFirst("^0+(?!$)", "");
                    break;
                case 2:
                    cal3.set(Calendar.DAY_OF_MONTH, date);
                    cal3.set(Calendar.MONTH, month-1);
                    cal3.set(Calendar.HOUR_OF_DAY, 11);
                    cal3.set(Calendar.MINUTE, 55);
                    cal3.add(Calendar.DATE, rest3);
                    rest3Date = cal3.getTimeInMillis();
                    r3 = day.format(cal3.getTime()).replaceFirst("^0+(?!$)", "");
                    r3 += "/" + mon.format(cal3.getTime()).replaceFirst("^0+(?!$)", "");
                    r3 += "-" + year.format(cal3.getTime()).replaceFirst("^0+(?!$)", "");
                    break;
                case 3:
                    cal4.set(Calendar.DAY_OF_MONTH, date);
                    cal4.set(Calendar.MONTH, month-1);
                    cal4.set(Calendar.HOUR_OF_DAY, 11);
                    cal4.set(Calendar.MINUTE, 55);
                    cal4.add(Calendar.DATE, rest4);
                    rest4Date = cal4.getTimeInMillis();
                    r4 = day.format(cal4.getTime()).replaceFirst("^0+(?!$)", "");
                    r4 += "/" + mon.format(cal4.getTime()).replaceFirst("^0+(?!$)", "");
                    r4 += "-" + year.format(cal4.getTime()).replaceFirst("^0+(?!$)", "");
                    break;
                case 4:
                    cal5.set(Calendar.DAY_OF_MONTH, date);
                    cal5.set(Calendar.MONTH, month-1);
                    cal5.set(Calendar.HOUR_OF_DAY, 11);
                    cal5.set(Calendar.MINUTE, 55);
                    cal5.add(Calendar.DATE, rest5);
                    rest5Date =cal5.getTimeInMillis();
                    r5 = day.format(cal5.getTime()).replaceFirst("^0+(?!$)", "");
                    r5 += "/" + mon.format(cal5.getTime()).replaceFirst("^0+(?!$)", "");
                    r5 += "-" + year.format(cal5.getTime()).replaceFirst("^0+(?!$)", "");
                    break;
                case 5:
                    cal6.set(Calendar.DAY_OF_MONTH, date);
                    cal6.set(Calendar.MONTH, month-1);
                    cal6.set(Calendar.HOUR_OF_DAY, 11);
                    cal6.set(Calendar.MINUTE, 55);
                    cal6.add(Calendar.DATE, rest6);
                    rest6Date = cal6.getTimeInMillis();
                    r6 = day.format(cal6.getTime()).replaceFirst("^0+(?!$)", "");
                    r6 += "/" + mon.format(cal6.getTime()).replaceFirst("^0+(?!$)", "");
                    r6 += "-" + year.format(cal6.getTime()).replaceFirst("^0+(?!$)", "");
                    break;
            }
        }

        TextView tv1 = (TextView) root.findViewById(R.id.r1);
        TextView tv2 = (TextView) root.findViewById(R.id.r2);
        TextView tv3 = (TextView) root.findViewById(R.id.r3);
        TextView tv4 = (TextView) root.findViewById(R.id.r4);
        TextView tv5 = (TextView) root.findViewById(R.id.r5);
        TextView tv6 = (TextView) root.findViewById(R.id.r6);

        tv1.setText(r1);
        if(rest1Date < currentDate) {
            tv1.setTextColor(Color.GREEN);
        } else {
            tv1.setTextColor(Color.BLACK);
        }
        tv2.setText(r2);
        if(rest2Date < currentDate) {
            tv2.setTextColor(Color.GREEN);
        } else {
            tv2.setTextColor(Color.BLACK);
        }
        tv3.setText(r3);
        if(rest3Date < currentDate) {
            tv3.setTextColor(Color.GREEN);
        } else {
            tv3.setTextColor(Color.BLACK);
        }
        tv4.setText(r4);
        if(rest4Date < currentDate) {
            tv4.setTextColor(Color.GREEN);
        } else {
            tv4.setTextColor(Color.BLACK);
        }
        tv5.setText(r5);
        if(rest5Date < currentDate) {
            tv5.setTextColor(Color.GREEN);
        } else {
            tv5.setTextColor(Color.BLACK);
        }
        tv6.setText(r6);
        if(rest6Date < currentDate) {
            tv6.setTextColor(Color.GREEN);
        } else {
            tv6.setTextColor(Color.BLACK);
        }

    }

}
