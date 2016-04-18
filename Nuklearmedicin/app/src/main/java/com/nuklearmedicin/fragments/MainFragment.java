package com.nuklearmedicin.fragments;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nuklearmedicin.R;

/**
 * Created by Mikael on 2016-04-13.
 */
public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        /* Set custom font to buttons */
        TextView beforeButton = (TextView) rootView.findViewById(R.id.buttonBefore);
        TextView duringButton = (TextView) rootView.findViewById(R.id.buttonDuring);
        TextView afterButton = (TextView) rootView.findViewById(R.id.buttonAfter);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/myfont.ttf");
        beforeButton.setTypeface(font);
        duringButton.setTypeface(font);
        afterButton.setTypeface(font);

        return rootView;

    }

}
