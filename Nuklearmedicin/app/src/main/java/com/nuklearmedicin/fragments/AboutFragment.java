package com.nuklearmedicin.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.nuklearmedicin.HandleXml;
import com.nuklearmedicin.R;

/**
 * Created by mikae on 2016-05-06.
 */
public class AboutFragment extends Fragment {

    WebView wv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        wv = (WebView) rootView.findViewById(R.id.about_webview);

        HandleXml handleXml = new HandleXml();
        String restarray[] = handleXml.getContent(getContext(), 1, "About");

        String justified = "<html><body style=\"text-align:justify\">" + restarray[0] + "</body></html>";

        wv.loadData(justified, "text/html; charset=utf-8", "utf-8");

        return rootView;

    }
}
