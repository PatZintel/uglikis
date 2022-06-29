
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		sign_in_screen
	 *	@date 		1656266114860
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
import android.widget.TextView;
import android.widget.ImageView;

import com.google.android.gms.common.SignInButton;

	public class sign_in_screen_activity extends Activity {

	
	private View _bg__sign_in_screen;
	private TextView sign_in;
	private TextView already_have_an_account_;
	private Button button_ek1;
	private View rectangle_5239;
	private TextView password;
	private View rectangle_5239_ek1;
	private TextView username;
	private SignInButton google_sign_in_b;
	private Button button_ek5;
	private View line_13;
	private TextView or;
	private TextView sign_up;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_in_screen);

		
		_bg__sign_in_screen = (View) findViewById(R.id._bg__sign_in_screen);
		sign_in = (TextView) findViewById(R.id.sign_in);
		already_have_an_account_ = (TextView) findViewById(R.id.already_have_an_account_);
		button_ek1 = (Button) findViewById(R.id.button_ek1);
		google_sign_in_b = (SignInButton) findViewById(R.id.sign_in_button);
		button_ek5 = (Button) findViewById(R.id.button_ek5);
		line_13 = (View) findViewById(R.id.line_13);
		or = (TextView) findViewById(R.id.or);
		sign_up = (TextView) findViewById(R.id.sign_up);
	
		
		//custom code goes here

		google_sign_in_b.setStyle(SignInButton.SIZE_WIDE, SignInButton.COLOR_AUTO);

		button_ek1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent nextScreen = new Intent(getApplicationContext(), specific_activity_activity.class);
				startActivity(nextScreen);
			}
		});
	
	}
}
	
	