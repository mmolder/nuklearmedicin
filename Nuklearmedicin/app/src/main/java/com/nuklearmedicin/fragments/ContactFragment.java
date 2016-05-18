package com.nuklearmedicin.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nuklearmedicin.HandleXml;
import com.nuklearmedicin.R;

import org.w3c.dom.Text;

/**
 * Created by Mikael on 2016-04-13.
 */
public class ContactFragment extends Fragment implements OnMapReadyCallback {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
        TextView title = (TextView) rootView.findViewById(R.id.contact_title);
        TextView address = (TextView) rootView.findViewById(R.id.contact_address);
        TextView phone = (TextView) rootView.findViewById(R.id.contact_phone);

        HandleXml content = new HandleXml();
        String restarray[] = content.getContent(getContext(), 3, "Contact");

        title.setText(restarray[0].replace("\\n", "\n"));
        address.setText(restarray[1].replace("\\n", "\n"));
        phone.setText(restarray[2].replace("\\n", "\n"));

        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment fragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng karolinska = new LatLng(59.350827, 18.033628);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(karolinska, 14));

        googleMap.addMarker(new MarkerOptions()
                .title("Endokrinmottagning")
                .snippet("Karolinska Universitetssjukhuset Solna, D2:03, Stockholm")
                .position(karolinska));
    }
}
