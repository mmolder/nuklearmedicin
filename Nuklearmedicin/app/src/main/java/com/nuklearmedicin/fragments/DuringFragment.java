package com.nuklearmedicin.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nuklearmedicin.HandleXml;
import com.nuklearmedicin.R;

/**
 * Created by mikae on 2016-04-15.
 */
public class DuringFragment extends Fragment {

    TextView during_1_content;
    TextView during_2_content;
    TextView during_3_content;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_during, container, false);

        HandleXml handleXml = new HandleXml();
        String restarray[] = handleXml.getContent(getContext(), 3, "During");

        during_1_content = (TextView) rootView.findViewById(R.id.during_1_content);
        during_1_content.setVisibility(View.GONE);
        during_1_content.setText(restarray[0].replace("\\n","\n"));

        during_2_content = (TextView) rootView.findViewById(R.id.during_2_content);
        during_2_content.setVisibility(View.GONE);
        during_2_content.setText(restarray[1].replace("\\n","\n"));

        during_3_content = (TextView) rootView.findViewById(R.id.during_3_content);
        during_3_content.setVisibility(View.GONE);
        during_3_content.setText(restarray[2].replace("\\n","\n"));

        return rootView;

    }

}
