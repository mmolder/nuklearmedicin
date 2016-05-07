package com.nuklearmedicin.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
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
public class AfterFragment extends Fragment {

    TextView rest_1_content;
    TextView rest_2_content;
    TextView rest_3_content;
    TextView rest_4_content;
    TextView rest_5_content;
    TextView rest_6_content;
    TextView undertitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_after, container, false);

        TextView title = (TextView) rootView.findViewById(R.id.title_after_fragment);
        /* Set custom font to buttons */

        TextView rest1 = (TextView) rootView.findViewById(R.id.rest_1);
        TextView rest2 = (TextView) rootView.findViewById(R.id.rest_2);
        TextView rest3 = (TextView) rootView.findViewById(R.id.rest_3);
        TextView rest4 = (TextView) rootView.findViewById(R.id.rest_4);
        TextView rest5 = (TextView) rootView.findViewById(R.id.rest_5);
        TextView rest6 = (TextView) rootView.findViewById(R.id.rest_6);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/myfont.ttf");
        //title.setTypeface(font);

        HandleXml handleXml = new HandleXml();
        String restarray[] = handleXml.getContent(getContext(), 7, "After");

        /* hide some content */
        rest_1_content = (TextView) rootView.findViewById(R.id.rest_1_content);
        rest_1_content.setVisibility(View.GONE);
        rest_1_content.setText(restarray[0].replace("\\n","\n"));

        rest_2_content = (TextView) rootView.findViewById(R.id.rest_2_content);
        rest_2_content.setVisibility(View.GONE);
        rest_2_content.setText(restarray[1].replace("\\n","\n"));

        rest_3_content = (TextView) rootView.findViewById(R.id.rest_3_content);
        rest_3_content.setVisibility(View.GONE);
        rest_3_content.setText(restarray[2].replace("\\n","\n"));

        rest_4_content = (TextView) rootView.findViewById(R.id.rest_4_content);
        rest_4_content.setVisibility(View.GONE);
        rest_4_content.setText(restarray[3].replace("\\n","\n"));

        rest_5_content = (TextView) rootView.findViewById(R.id.rest_5_content);
        rest_5_content.setVisibility(View.GONE);
        rest_5_content.setText(restarray[4].replace("\\n","\n"));

        rest_6_content = (TextView) rootView.findViewById(R.id.rest_6_content);
        rest_6_content.setVisibility(View.GONE);
        rest_6_content.setText(restarray[5].replace("\\n","\n"));

        undertitle = (TextView) rootView.findViewById(R.id.after_undertitle);
        undertitle.setText(restarray[6].replace("\\n","\n"));

        int showOnStart = 0;
        Bundle bundle = this.getArguments();
        if(bundle != null){
            showOnStart = bundle.getInt("rest", 0);
        }

        ScrollView sv = (ScrollView) rootView.findViewById(R.id.scroll_view);
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(DrawerLayout.LayoutParams.MATCH_PARENT, DrawerLayout.LayoutParams.MATCH_PARENT);
        Drawable arrowUp = getResources().getDrawable(R.mipmap.ic_expand_less_white_24dp);
        Drawable arrowDown = getResources().getDrawable(R.mipmap.ic_expand_more_white_24dp);
        switch(showOnStart){
            case 1:
                /* show content */
                rest_1_content.setVisibility(View.VISIBLE);
                /* set all margins to 0 */
                llp.setMargins(0,0,0,0);
                rest1.setLayoutParams(llp);
                /* change icon to arrow up */
                rest1.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                /* remove two rounded corners */
                rest1.setBackgroundResource(R.drawable.dropdown_1_edge);
                /* slide down animation */
                slide_down(getContext(), rest_1_content);
                rest1.getParent().requestChildFocus(rest1,rest1);
                break;
            case 2:
                /* show content */
                rest_2_content.setVisibility(View.VISIBLE);
                /* set all margins to 0 */
                llp.setMargins(0,0,0,0);
                rest2.setLayoutParams(llp);
                /* change icon to arrow up */
                rest2.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                /* remove two rounded corners */
                rest2.setBackgroundResource(R.drawable.dropdown_2_edge);
                /* slide down animation */
                slide_down(getContext(), rest_2_content);
                rest2.getParent().requestChildFocus(rest2,rest2);
                break;
            case 3:
                /* show content */
                rest_3_content.setVisibility(View.VISIBLE);
                /* set all margins to 0 */
                llp.setMargins(0,0,0,0);
                rest3.setLayoutParams(llp);
                /* change icon to arrow up */
                rest3.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                /* remove two rounded corners */
                rest3.setBackgroundResource(R.drawable.dropdown_3_edge);
                /* slide down animation */
                slide_down(getContext(), rest_3_content);
                rest_3_content.getParent().requestChildFocus(rest_3_content,rest_3_content);
                break;
            case 4:
                /* show content */
                rest_4_content.setVisibility(View.VISIBLE);
                /* set all margins to 0 */
                llp.setMargins(0,0,0,0);
                rest4.setLayoutParams(llp);
                /* change icon to arrow up */
                rest4.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                /* remove two rounded corners */
                rest4.setBackgroundResource(R.drawable.dropdown_4_edge);
                /* slide down animation */
                slide_down(getContext(), rest_4_content);
                rest_4_content.getParent().requestChildFocus(rest_4_content,rest_4_content);
                break;
            case 5:
                /* show content */
                rest_5_content.setVisibility(View.VISIBLE);
                /* set all margins to 0 */
                llp.setMargins(0,0,0,0);
                rest5.setLayoutParams(llp);
                /* change icon to arrow up */
                rest5.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                /* remove two rounded corners */
                rest5.setBackgroundResource(R.drawable.dropdown_5_edge);
                /* slide down animation */
                slide_down(getContext(), rest_5_content);
                rest_5_content.getParent().requestChildFocus(rest_5_content,rest_5_content);
                break;
            case 6:
                 /* show content */
                rest_6_content.setVisibility(View.VISIBLE);
                /* set all margins to 0 */
                llp.setMargins(0,0,0,0);
                rest6.setLayoutParams(llp);
                /* change icon to arrow up */
                rest6.setCompoundDrawablesWithIntrinsicBounds(null,null,arrowUp,null);
                /* remove two rounded corners */
                rest6.setBackgroundResource(R.drawable.dropdown_6_edge);
                /* slide down animation */
                slide_down(getContext(), rest_6_content);
                rest_6_content.getParent().requestChildFocus(rest_6_content,rest_6_content);
                break;
        }

        return rootView;

    }

    /* slide down animation for after fragment */
    public static void slide_down(Context ctx, View v){
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
        if(a != null){
            a.reset();
            if(v != null){
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }

    /* slide up animation for after fragment */
    public static void slide_up(Context ctx, View v){
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_up);
        if(a != null){
            a.reset();
            if(v != null){
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }
}
