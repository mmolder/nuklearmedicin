package com.nuklearmedicin.fragments;

import android.graphics.Typeface;
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
public class BeforeFragment extends Fragment {
    TextView pregnant_info;
    TextView medic_info;
    TextView earlier_info;
    TextView other_info;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_before, container, false);

        //TextView title = (TextView) rootView.findViewById(R.id.);
        /* Set custom font to buttons */

        TextView rest1 = (TextView) rootView.findViewById(R.id.pregnant);
        TextView rest2 = (TextView) rootView.findViewById(R.id.medic);
        TextView rest3 = (TextView) rootView.findViewById(R.id.earlier);
        TextView rest4 = (TextView) rootView.findViewById(R.id.other);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/myfont.ttf");
        //title.setTypeface(font);

        HandleXml handleXml = new HandleXml();
        String restarray[] = handleXml.getContent(getContext(), 2, "Before");


        pregnant_info= (TextView) rootView.findViewById(R.id.pregnant_info);
        pregnant_info.setVisibility(View.GONE);
        pregnant_info.setText(restarray[0].replace("\\n","\n"));

        medic_info= (TextView) rootView.findViewById(R.id.medic_info);
        medic_info.setVisibility(View.GONE);
        medic_info.setText(restarray[1].replace("\\n","\n"));
        return rootView;
    }

}
