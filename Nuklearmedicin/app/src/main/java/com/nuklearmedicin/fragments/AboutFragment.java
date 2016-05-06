package com.nuklearmedicin.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.nuklearmedicin.HandleXml;
import com.nuklearmedicin.R;

/**
 * Created by mikae on 2016-05-06.
 */
public class AboutFragment extends Fragment {

    TextView title;
    TextView undertitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        title = (TextView) rootView.findViewById(R.id.about_title);
        undertitle = (TextView) rootView.findViewById(R.id.about_undertitle);

        HandleXml handleXml = new HandleXml();
        String restarray[] = handleXml.getContent(getContext(), 1, "About");

        title.setText("Om applikationen");
        undertitle.setText(restarray[0].replace("\\n","\n"));

        return rootView;

    }
}
