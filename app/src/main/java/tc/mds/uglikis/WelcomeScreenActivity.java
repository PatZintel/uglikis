
	 
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

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.*;

import com.firebase.ui.auth.KickoffActivity;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class WelcomeScreenActivity extends AppCompatActivity {

	
	private View _bg__welcome_screen;
	private ImageView achievements___accomplishment__target__flag__woman__mountain_climber__promotion__goal_ek1;
	private TextView welcome_to;
	private TextView uglikis;
	private Button button_ek1;

/*
	public void createSignInIntent() {
		// [START auth_fui_create_intent]
		// Choose authentication providers
		List<AuthUI.IdpConfig> providers = Arrays.asList(
				new AuthUI.IdpConfig.EmailBuilder().build(),
				new AuthUI.IdpConfig.GoogleBuilder().build());

		// Create and launch sign-in intent
		Intent signInIntent = AuthUI.getInstance()
				.createSignInIntentBuilder()
				.setAvailableProviders(providers)
				.build();
		signInLauncher.launch(signInIntent);
		// [END auth_fui_create_intent]
	}

		private final ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
				new FirebaseAuthUIActivityResultContract(),
				(ActivityResultCallback<FirebaseAuthUIAuthenticationResult>) result -> onSignInResult(result));


		// [START auth_fui_result]
		private void onSignInResult(FirebaseAuthUIAuthenticationResult result) {
			IdpResponse response = result.getIdpResponse();
			if (result.getResultCode() == RESULT_OK) {
				// Successfully signed in
				FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
				Intent nextScreen = new Intent(getApplicationContext(), KickoffActivity.class);
				startActivity(nextScreen);
				// ...
			} else {
				// Sign in failed. If response is null the user canceled the
				// sign-in flow using the back button. Otherwise check
				// response.getError().getErrorCode() and handle the error.
				// ...
			}
		}
		// [END auth_fui_result]
*/
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
				Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class); //
				startActivity(nextScreen);
				//createSignInIntent();
			}
		});
	
	}
}
	
	