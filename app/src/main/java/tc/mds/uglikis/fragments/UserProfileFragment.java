package tc.mds.uglikis.fragments;

/*
 *	This content is generated from the API File Info.
 *	(Alt+Shift+Ctrl+I).
 *
 *	@desc
 *	@file 		specific_activity
 *	@date 		1656251800198
 *	@title 		Main Game
 *	@author
 *	@keywords
 *	@generator 	Export Kit v1.3.figma
 *
 */

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import tc.mds.uglikis.MainActivity;
import tc.mds.uglikis.R;

public class UserProfileFragment extends Fragment {


    private View __bg__specific_activity;
    private ImageView image_10;
    private ImageView image_13;
    private TextView tum;
    private TextView mds;
    private TextView arcisstra_e_21__80333;
    private ImageView image_15;
    private TextView mobility_data_space_center;
    private TextView approx__7_min_walk;
    private ImageView rectangle_ek1;
    private TextView large_title;
    private ImageView vector_1;
    private ImageView back_arrow_specific;
    private ImageView bg_destination_specific_map;
    private TextView next_milestone___48g_co2;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UserProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_activities_home_screen, container, false);


        __bg__specific_activity = (View) view.findViewById(R.id.__bg__specific_activity);
        image_10 = (ImageView) view.findViewById(R.id.image_10);
        image_13 = (ImageView) view.findViewById(R.id.image_13);
        tum = (TextView) view.findViewById(R.id.tum);
        mds = (TextView) view.findViewById(R.id.mds);
        arcisstra_e_21__80333 = (TextView) view.findViewById(R.id.arcisstra_e_21__80333);
        image_15 = (ImageView) view.findViewById(R.id.image_15);
        mobility_data_space_center = (TextView) view.findViewById(R.id.mobility_data_space_center);
        approx__7_min_walk = (TextView) view.findViewById(R.id.approx__7_min_walk);
        rectangle_ek1 = (ImageView) view.findViewById(R.id.rectangle_ek1);
        large_title = (TextView) view.findViewById(R.id.large_title);
        vector_1 = (ImageView) view.findViewById(R.id.vector_1);
        back_arrow_specific = (ImageView) view.findViewById(R.id.back_arrow_specific);
        bg_destination_specific_map = (ImageView) view.findViewById(R.id.bg_destination_specific_map);
        next_milestone___48g_co2 = (TextView) view.findViewById(R.id.next_milestone___48g_co2);

        //custom code goes here
        __bg__specific_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("black", "onclick run in specAct fragment");
                Intent nextScreen = new Intent(view.getContext(), MainActivity.class);
                startActivity(nextScreen);
            }
        });
        return view;
    }
}
