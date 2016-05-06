package com.nuklearmedicin.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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
        String restarray[] = handleXml.getContent(getContext(), 4, "Before");


        pregnant_info = (TextView) rootView.findViewById(R.id.pregnant_info);
        pregnant_info.setVisibility(View.GONE);
        pregnant_info.setText(restarray[0].replace("\\n", "\n"));

        medic_info = (TextView) rootView.findViewById(R.id.medic_info);
        medic_info.setVisibility(View.GONE);
        medic_info.setText(restarray[1].replace("\\n", "\n"));

        earlier_info = (TextView) rootView.findViewById(R.id.earlier_info);
        earlier_info.setVisibility(View.GONE);
        earlier_info.setText(restarray[2].replace("\\n", "\n"));

        other_info = (TextView) rootView.findViewById(R.id.other_info);
        other_info.setVisibility(View.GONE);
        other_info.setText(restarray[3].replace("\\n", "\n"));

        int showOnStart = 0;
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            showOnStart = bundle.getInt("rest", 0);
        }
        ScrollView sv = (ScrollView) rootView.findViewById(R.id.beforescroll);
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(DrawerLayout.LayoutParams.MATCH_PARENT, DrawerLayout.LayoutParams.MATCH_PARENT);
        Drawable arrowUp = getResources().getDrawable(R.mipmap.ic_expand_less_white_24dp);
        Drawable arrowDown = getResources().getDrawable(R.mipmap.ic_expand_more_white_24dp);
        switch (showOnStart) {
            case 1:
                /* show content */
                pregnant_info.setVisibility(View.VISIBLE);
                /* set all margins to 0 */
                llp.setMargins(0, 0, 0, 0);
                rest1.setLayoutParams(llp);
                /* change icon to arrow up */
                rest1.setCompoundDrawablesWithIntrinsicBounds(null, null, arrowUp, null);
                /* remove two rounded corners */
                rest1.setBackgroundResource(R.drawable.rest_corner);
                /* slide down animation */
                slide_down(getContext(), pregnant_info);
                rest1.getParent().requestChildFocus(rest1, rest1);
                break;
            case 2:
                /* show content */
                medic_info.setVisibility(View.VISIBLE);
                /* set all margins to 0 */
                llp.setMargins(0, 0, 0, 0);
                rest2.setLayoutParams(llp);
                /* change icon to arrow up */
                rest2.setCompoundDrawablesWithIntrinsicBounds(null, null, arrowUp, null);
                /* remove two rounded corners */
                rest2.setBackgroundResource(R.drawable.rest_corner);
                /* slide down animation */
                slide_down(getContext(), medic_info);
                rest2.getParent().requestChildFocus(rest2, rest2);
                break;
            case 3:
                /* show content */
                earlier_info.setVisibility(View.VISIBLE);
                /* set all margins to 0 */
                llp.setMargins(0, 0, 0, 0);
                rest3.setLayoutParams(llp);
                /* change icon to arrow up */
                rest3.setCompoundDrawablesWithIntrinsicBounds(null, null, arrowUp, null);
                /* remove two rounded corners */
                rest3.setBackgroundResource(R.drawable.rest_corner);
                /* slide down animation */
                slide_down(getContext(), earlier_info);
                earlier_info.getParent().requestChildFocus(earlier_info, earlier_info);
                break;
            case 4:
                /* show content */
                other_info.setVisibility(View.VISIBLE);
                /* set all margins to 0 */
                llp.setMargins(0, 0, 0, 0);
                rest4.setLayoutParams(llp);
                /* change icon to arrow up */
                rest4.setCompoundDrawablesWithIntrinsicBounds(null, null, arrowUp, null);
                /* remove two rounded corners */
                rest4.setBackgroundResource(R.drawable.rest_corner);
                /* slide down animation */
                slide_down(getContext(), other_info);
                other_info.getParent().requestChildFocus(other_info, other_info);
                break;
        }
            return rootView;
    }
    /* slide down animation for before fragment */

    public static void slide_down(Context ctx, View v) {
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
        if (a != null) {
            a.reset();
            if (v != null) {
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }

    /* slide up animation for before fragment */
    public static void slide_up(Context ctx, View v) {
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_up);
        if (a != null) {
            a.reset();
            if (v != null) {
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }
}
