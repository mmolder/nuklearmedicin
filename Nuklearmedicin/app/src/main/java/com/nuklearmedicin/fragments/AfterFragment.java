package com.nuklearmedicin.fragments;

import android.graphics.Typeface;
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
    TextView rest_3_content;
    TextView rest_4_content;
    TextView rest_5_content;
    TextView rest_6_content;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_after, container, false);

        /* Set custom font to buttons */
        TextView rest1 = (TextView) rootView.findViewById(R.id.rest_1);
        TextView rest2 = (TextView) rootView.findViewById(R.id.rest_2);
        TextView rest3 = (TextView) rootView.findViewById(R.id.rest_3);
        TextView rest4 = (TextView) rootView.findViewById(R.id.rest_4);
        TextView rest5 = (TextView) rootView.findViewById(R.id.rest_5);
        TextView rest6 = (TextView) rootView.findViewById(R.id.rest_6);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/myfont.ttf");
        rest1.setTypeface(font);
        rest2.setTypeface(font);
        rest3.setTypeface(font);
        rest4.setTypeface(font);
        rest5.setTypeface(font);
        rest6.setTypeface(font);

        /* hide some content */
        rest_1_content = (TextView) rootView.findViewById(R.id.rest_1_content);
        rest_1_content.setVisibility(View.GONE);
        rest_2_content = (TextView) rootView.findViewById(R.id.rest_2_content);
        rest_2_content.setVisibility(View.GONE);
        rest_3_content = (TextView) rootView.findViewById(R.id.rest_3_content);
        rest_3_content.setVisibility(View.GONE);
        rest_4_content = (TextView) rootView.findViewById(R.id.rest_4_content);
        rest_4_content.setVisibility(View.GONE);
        rest_5_content = (TextView) rootView.findViewById(R.id.rest_5_content);
        rest_5_content.setVisibility(View.GONE);
        rest_6_content = (TextView) rootView.findViewById(R.id.rest_6_content);
        rest_6_content.setVisibility(View.GONE);

        return rootView;

    }

}
