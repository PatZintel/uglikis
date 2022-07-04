
	 
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
	

package tc.mds.uglikis;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityDetailViewActivity extends Activity {

	
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

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.specific_activity);

		
		__bg__specific_activity = (View) findViewById(R.id.__bg__specific_activity);
		image_10 = (ImageView) findViewById(R.id.image_10);
		image_13 = (ImageView) findViewById(R.id.image_13);
		tum = (TextView) findViewById(R.id.tum);
		mds = (TextView) findViewById(R.id.mds);
		arcisstra_e_21__80333 = (TextView) findViewById(R.id.arcisstra_e_21__80333);
		image_15 = (ImageView) findViewById(R.id.image_15);
		mobility_data_space_center = (TextView) findViewById(R.id.mobility_data_space_center);
		approx__7_min_walk = (TextView) findViewById(R.id.approx__7_min_walk);
		rectangle_ek1 = (ImageView) findViewById(R.id.rectangle_ek1);
		large_title = (TextView) findViewById(R.id.large_title);
		vector_1 = (ImageView) findViewById(R.id.vector_1);
		back_arrow_specific = (ImageView) findViewById(R.id.back_arrow_specific);
		bg_destination_specific_map = (ImageView) findViewById(R.id.bg_destination_specific_map);
		next_milestone___48g_co2 = (TextView) findViewById(R.id.next_milestone___48g_co2);
		
		//custom code goes here
		__bg__specific_activity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(nextScreen);
			}
		});
	}
}
	
	