package com.nuklearmedicin.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.nuklearmedicin.MainActivity;
import com.nuklearmedicin.R;

/**
 * Created by Mikael on 2016-04-13.
 */
public class RestrictionFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_restrictions, container, false);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = (LayoutInflater.from(getContext())).inflate(R.layout.user_input, null);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getContext());
                alertBuilder.setView(v);

                final EditText userInput = (EditText) v.findViewById(R.id.userinput);

                alertBuilder.setPositiveButton("Lägg till", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        parseUserInput(userInput.getText().toString(), rootView);
                    }
                });

                alertBuilder.setNegativeButton("Avbryt", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                Dialog dialog = alertBuilder.create();
                dialog.show();
            }
        });

        return rootView;

    }

    public void parseUserInput(String input, View root) {
        char date, month, rest1, rest2, rest3, rest4, rest5, rest6;
        char[] restArray = input.toCharArray();
        date = restArray[0];
        month = restArray[1];
        rest1 = restArray[2];
        rest2 = restArray[3];
        rest3 = restArray[4];
        rest4 = restArray[5];
        rest5 = restArray[6];
        rest6 = restArray[7];

        TextView tv1 = (TextView) root.findViewById(R.id.r1);
        TextView tv2 = (TextView) root.findViewById(R.id.r2);
        TextView tv3 = (TextView) root.findViewById(R.id.r3);
    }

}
