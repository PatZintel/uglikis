package tc.mds.uglikis;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

import tc.mds.uglikis.adapter.LeaderboardListAdapter;
import tc.mds.uglikis.databinding.ActivityMainBinding;
import tc.mds.uglikis.fragments.ActivityFragment;
import tc.mds.uglikis.fragments.EducationFragment;
import tc.mds.uglikis.fragments.LeaderboardFragment;
import tc.mds.uglikis.fragments.UserProfileFragment;
import tc.mds.uglikis.model.Profile;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnItemSelectedListener{

    private ActivityMainBinding binding;
    BottomNavigationView bottomNavigationView;
    LeaderboardFragment leaderboardFragment = new LeaderboardFragment();
    ActivityFragment activityFragment = new ActivityFragment();
    EducationFragment educationFragment = new EducationFragment();
    UserProfileFragment profileFragment = new UserProfileFragment();
    private TextView coinAmount;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        coinAmount = (TextView) findViewById(R.id.coin_amount);
        coinAmount.setText("420 UCs");

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.activities);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_activities, R.id.navigation_education, R.id.navigation_leaderboard, R.id.navigation_profile)
                .build();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.activities:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, activityFragment).commit();
                return true;

            case R.id.education:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, educationFragment).commit();
                return true;

            case R.id.leaderboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, leaderboardFragment).commit();
                return true;

            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, profileFragment).commit();
                return true;
        }
        return false;
    }

}
