package com.nuklearmedicin.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nuklearmedicin.R;

/**
 * Created by mikae on 2016-04-15.
 */
public class AfterFragment extends Fragment {

    TextView rest_1_content;
    TextView rest_2_content;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_after, container, false);

        /* hide some content */
        rest_1_content = (TextView) rootView.findViewById(R.id.rest_1_content);
        rest_1_content.setVisibility(View.GONE);
        rest_2_content = (TextView) rootView.findViewById(R.id.rest_2_content);
        rest_2_content.setVisibility(View.GONE);

        return rootView;

    }

}
