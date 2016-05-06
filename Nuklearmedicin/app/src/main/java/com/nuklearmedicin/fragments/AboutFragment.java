package com.nuklearmedicin.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

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

        return rootView;

    }
}
