package tc.mds.uglikis;

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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import tc.mds.uglikis.model.ActivityType;

public class SpecificActivitiesActivity extends Activity {

    private MainActivity mainActivity;

    private ImageView backButton;
    private TextView activityTitle;
    private TextInputEditText parameterInput;
    private TextView resultText;
    private TextView unitText;
    private Button submitButton;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SpecificActivitiesActivity() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.specific_activity);
        backButton = findViewById(R.id.back_arrow_specific);
        activityTitle = findViewById(R.id.large_title);
        parameterInput = findViewById(R.id.parameter_input_text);
        resultText = findViewById(R.id.result_text);
        unitText = findViewById(R.id.unit_text);
        submitButton = findViewById(R.id.submit_button);
        submitButton.setClickable(false);

        activityTitle.setText(getIntent().getCharSequenceExtra("title"));
        int type = getIntent().getIntExtra("type", -1);


        switch(type){
            case 0:
                unitText.setText("Kilos");
                break;
            case 1:
                unitText.setText("Kms");
                break;
            case 2:
                unitText.setText("meals");
                break;
        }
        int rewardRate = getIntent().getIntExtra("rewardRate", 0);
        parameterInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() > 0){
                    resultText.setText("You will earn " + (Integer.parseInt(s.toString()) * rewardRate) + " UCs from this activity.");
                    submitButton.setClickable(true);
                }
                else{
                    submitButton.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                int reward = Integer.parseInt(String.valueOf(parameterInput.getText())) * rewardRate;
                MainActivity.coins += reward;
                KnowledgeBase.addPointsToProfile(reward);
                MainActivity.redrawOnce = true;
                finish();
                /*
                Intent nextScreen = new Intent(v.getContext(), MainActivity.class);
                int reward = Integer.parseInt(String.valueOf(parameterInput.getText())) * rewardRate;
                nextScreen.putExtra("reward", reward);
                startActivity(nextScreen);*/
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("black", "onclick run in specAct fragment");
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });

    }
}