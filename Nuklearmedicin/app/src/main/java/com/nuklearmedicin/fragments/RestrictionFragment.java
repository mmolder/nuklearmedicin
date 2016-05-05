package com.nuklearmedicin.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nuklearmedicin.HandleXml;
import com.nuklearmedicin.MainActivity;
import com.nuklearmedicin.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Mikael on 2016-04-13.
 */
public class RestrictionFragment extends Fragment {

    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    Calendar cal3 = Calendar.getInstance();
    Calendar cal4 = Calendar.getInstance();
    Calendar cal5 = Calendar.getInstance();
    Calendar cal6 = Calendar.getInstance();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_restrictions, container, false);

        HandleXml handleXml = new HandleXml();
        String content[] = handleXml.getContent(getContext(), 2, "Restrictions");

        TextView desc = (TextView) rootView.findViewById(R.id.desc_yellowcard);
        desc.setText(content[0].replace("\\n","\n"));

        TextView desc2 = (TextView) rootView.findViewById(R.id.desc_yellowcard2);
        desc2.setText(content[1].replace("\\n","\n"));

        /* read user code from memory if there is one */
        readFromMemory(rootView);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* get edit text from xml */
                View v = (LayoutInflater.from(getContext())).inflate(R.layout.user_input, null);

                final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getContext());
                /* add custom view to alert dialog */
                alertBuilder.setView(v);

                final EditText userInput = (EditText) v.findViewById(R.id.userinput);

                alertBuilder.setTitle("Ange din 8-siffriga kod");

                /* add positive button to alert dialog */
                alertBuilder.setPositiveButton("Lägg till", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                /* add negative button to alert dialog */
                alertBuilder.setNegativeButton("Avbryt", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                final Dialog d = alertBuilder.create();

                /* set listener on alert dialog */
                d.setOnShowListener(new DialogInterface.OnShowListener() {

                    @Override
                    public void onShow(final DialogInterface dialog) {
                        Button b = ((AlertDialog)d).getButton(AlertDialog.BUTTON_POSITIVE);
                        /* set on click listener on positive button */
                        b.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                /* if no user input, show error */
                                if(TextUtils.isEmpty(userInput.getText().toString())){
                                    userInput.setError("Ej giltig kod!");
                                }
                                /* ok user input, proceed */
                                else {
                                    TextView test = (TextView) rootView.findViewById(R.id.test);
                                    test.setText(userInput.getText());

                                    /* save user input to file in phone memory */
                                    try {
                                        FileOutputStream fileOutputStream = getContext().openFileOutput("user_code", Context.MODE_PRIVATE);
                                        fileOutputStream.write(userInput.getText().toString().getBytes());
                                        fileOutputStream.close();
                                        parseUserInput(userInput.getText().toString(), rootView);
                                        dialog.cancel();
                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    ((MainActivity)getActivity()).setAlarm(cal1, 1);
                                    ((MainActivity)getActivity()).setAlarm(cal2, 2);
                                    Toast.makeText(getContext(),"Alarm set", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                });
                d.show();
            }
        });

        return rootView;

    }

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

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");

        /*cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));*/

        for(i = 0; i < 6; i++){
            switch (i){
                case 0:
                    cal1.set(Calendar.DAY_OF_MONTH, date);
                    cal1.set(Calendar.MONTH, month-1);
                    cal1.set(Calendar.HOUR_OF_DAY, 10);
                    cal1.set(Calendar.MINUTE, 23);
                    cal1.add(Calendar.DATE, rest1);
                    r1 = sdf.format(cal1.getTime());
                    break;
                case 1:
                    cal2.set(Calendar.DAY_OF_MONTH, date);
                    cal2.set(Calendar.MONTH, month-1);
                    cal2.set(Calendar.HOUR_OF_DAY, 10);
                    cal2.set(Calendar.MINUTE, 23);
                    cal2.add(Calendar.DATE, rest2);
                    r2 = sdf.format(cal2.getTime());
                    break;
                case 2:
                    cal3.set(Calendar.DAY_OF_MONTH, date);
                    cal3.set(Calendar.MONTH, month-1);
                    cal3.set(Calendar.HOUR_OF_DAY, 16);
                    cal3.set(Calendar.MINUTE, 47);
                    cal3.add(Calendar.DATE, rest3);
                    r3 = sdf.format(cal3.getTime());
                    break;
                case 3:
                    cal4.set(Calendar.DAY_OF_MONTH, date);
                    cal4.set(Calendar.MONTH, month-1);
                    cal4.set(Calendar.HOUR_OF_DAY, 16);
                    cal4.set(Calendar.MINUTE, 48);
                    cal4.add(Calendar.DATE, rest4);
                    r4 = sdf.format(cal4.getTime());
                    break;
                case 4:
                    cal5.set(Calendar.DAY_OF_MONTH, date);
                    cal5.set(Calendar.MONTH, month-1);
                    cal5.set(Calendar.HOUR_OF_DAY, 16);
                    cal5.set(Calendar.MINUTE, 49);
                    cal5.add(Calendar.DATE, rest5);
                    r5 = sdf.format(cal5.getTime());
                    break;
                case 5:
                    cal6.set(Calendar.DAY_OF_MONTH, date);
                    cal6.set(Calendar.MONTH, month-1);
                    cal6.set(Calendar.HOUR_OF_DAY, 16);
                    cal6.set(Calendar.MINUTE, 50);
                    cal6.add(Calendar.DATE, rest6);
                    r6 = sdf.format(cal6.getTime());
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
        tv2.setText(r2);
        tv3.setText(r3);
        tv4.setText(r4);
        tv5.setText(r5);
        tv6.setText(r6);

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

}
