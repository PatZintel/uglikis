
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		welcome_screen
	 *	@date 		1656253075259
	 *	@title 		Main Game
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package tc.mds.uglikis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class welcome_screen_activity extends Activity {

	
	private View _bg__welcome_screen;
	private ImageView achievements___accomplishment__target__flag__woman__mountain_climber__promotion__goal_ek1;
	private TextView welcome_to;
	private TextView uglikis;
	private Button button_ek1;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_screen);

		
		_bg__welcome_screen = (View) findViewById(R.id._bg__welcome_screen);
		achievements___accomplishment__target__flag__woman__mountain_climber__promotion__goal_ek1 = (ImageView) findViewById(R.id.achievements___accomplishment__target__flag__woman__mountain_climber__promotion__goal_ek1);
		welcome_to = (TextView) findViewById(R.id.welcome_to);
		uglikis = (TextView) findViewById(R.id.uglikis);
		button_ek1 = (Button) findViewById(R.id.button_ek1);


		button_ek1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent nextScreen = new Intent(getApplicationContext(), sign_in_screen_activity.class);
				startActivity(nextScreen);
			}
		});
	
	}
}
	
	