package tc.mds.uglikis;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;
import java.util.List;

import tc.mds.uglikis.databinding.ActivityMainBinding;
import tc.mds.uglikis.fragments.ActivityFragment;
import tc.mds.uglikis.fragments.EducationFragment;
import tc.mds.uglikis.fragments.LeaderboardFragment;
import tc.mds.uglikis.fragments.LoadedFragment;
import tc.mds.uglikis.fragments.UserProfileFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnItemSelectedListener{

    public static int coins = 0;
    public static boolean redrawOnce = false;

    private ActivityMainBinding binding;
    private BottomNavigationView bottomNavigationView;
    private LeaderboardFragment leaderboardFragment = new LeaderboardFragment();
    private ActivityFragment activityFragment = new ActivityFragment();
    private EducationFragment educationFragment = new EducationFragment();
    private UserProfileFragment profileFragment = new UserProfileFragment();
    private TextView coinAmount;
    public KnowledgeBase knowledgeBase;
    private List<LoadedFragment> builtFragments = new LinkedList<LoadedFragment>();
    private FloatingActionButton gameButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(knowledgeBase == null) knowledgeBase = new KnowledgeBase(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        coinAmount = (TextView) findViewById(R.id.coin_amount);
        coinAmount.setText(coins + " UCs");
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.activities);
        gameButton = findViewById(R.id.fab);
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(v.getContext(), game_mockup_activity.class);
                startActivity(nextScreen);
            }
        });
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_activities, R.id.navigation_education, R.id.navigation_leaderboard, R.id.navigation_profile)
                .build();
    }

    public void updateUI(){
        for(LoadedFragment f : builtFragments){
            f.notifyDatasetChanged();
        }
        if(redrawOnce){
            this.recreate();
            redrawOnce = false;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.activities:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, activityFragment).commit();
                if(!builtFragments.contains(activityFragment)) builtFragments.add(activityFragment);
                return true;

            case R.id.education:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, educationFragment).commit();
                if(!builtFragments.contains(educationFragment)) builtFragments.add(educationFragment);
                return true;

            case R.id.leaderboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, leaderboardFragment).commit();
                if(!builtFragments.contains(leaderboardFragment)) builtFragments.add(leaderboardFragment);
                return true;

            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, profileFragment).commit();
                if(!builtFragments.contains(profileFragment)) builtFragments.add(profileFragment);
                return true;
        }
        return false;
    }
}