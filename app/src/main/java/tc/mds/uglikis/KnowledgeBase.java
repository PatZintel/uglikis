package tc.mds.uglikis;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import tc.mds.uglikis.model.Activity;
import tc.mds.uglikis.model.Article;
import tc.mds.uglikis.model.Profile;

public class KnowledgeBase {

    private DatabaseReference database;
    private FirebaseUser activeUser;
    private static Profile activeProfile = new Profile();
    private List<Article> articles = new LinkedList<Article>();
    private List<Activity> activities = new LinkedList<Activity>();
    private List<Profile> publicProfiles = new LinkedList<Profile>();
    private MainActivity mainActivity;

    public KnowledgeBase(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        instantiateKnowledgeBase();
        retrieveActivities();
        retrieveActiveProfile();
        retrieveArticles();
        retrievePublicProfileList();
    }


    private void instantiateKnowledgeBase(){
        database = FirebaseDatabase.getInstance("https://uglikis-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        activeUser = FirebaseAuth.getInstance().getCurrentUser();
    }

    private void retrieveActiveProfile(){
        ValueEventListener activeUserListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                activeProfile = snapshot.getValue(Profile.class);
                mainActivity.updateUI();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("firebase", "Error fetching data", error.toException());
            }
        };

        database.child("profiles").child(activeUser.getUid()).addValueEventListener(activeUserListener);
        if(activeProfile == null){
            activeProfile = new Profile(activeUser.getDisplayName(), activeUser.getDisplayName().toLowerCase());
            activeProfile.setAuthUserId(activeUser.getUid());
            updateProfileOnDB(activeProfile);
        }
    }

    private void retrievePublicProfileList(){
        ValueEventListener publicProfileListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                activeProfile = snapshot.getValue(Profile.class);
                mainActivity.updateUI();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("firebase", "Error fetching data", error.toException());
            }
        };

        database.child("publicProfiles").child(activeUser.getUid()).addValueEventListener(publicProfileListener);
        if(activeProfile == null){
            activeProfile = new Profile(activeUser.getDisplayName(), activeUser.getDisplayName().toLowerCase());
            updateProfileOnDB(activeProfile);
        }
    }

    private void retrieveActivities(){
        ValueEventListener activityListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot articleSnapshot : snapshot.getChildren()){
                    Activity activity = articleSnapshot.getValue(Activity.class);
                    if(!activities.contains(activity)) activities.add(activity);
                }
                mainActivity.updateUI();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("firebase", "Error fetching data", error.toException());
            }
        };
        database.child("activities").addValueEventListener(activityListener);
    }

    private void retrieveArticles(){
        ValueEventListener articleListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot articleSnapshot : snapshot.getChildren()){
                    Article article = articleSnapshot.getValue(Article.class);
                    if(!articles.contains(article)) articles.add(article);
                }
                mainActivity.updateUI();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("firebase", "Error fetching data", error.toException());
            }
        };
        database.child("articles").addValueEventListener(articleListener);
    }

    public void updateProfileOnDB(Profile profile){
        database.child("profiles").child(profile.getAuthUserId()).setValue(profile);
        Profile publicProfile = profile;
        database.child("publicProfiles").child(String.valueOf(profile.getAuthUserId())).setValue(publicProfile);
    }

    public void saveActivity(Activity activity){
        database.child("activities").child(String.valueOf(activity.getId())).setValue(activity);
    }

    public static void addPointsToProfile(int points){
        activeProfile.addPoints(points);
        DatabaseReference databaseTemp = FirebaseDatabase.getInstance("https://uglikis-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        databaseTemp.child("profiles").child(activeProfile.getAuthUserId()).setValue(activeProfile);
    };

    public Profile getActiveProfile() {
        return activeProfile;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void retrieveActiveUser(){

    }

    public void addPoints(int rewardAmount) {
        activeProfile.points += rewardAmount;
        updateProfileOnDB(activeProfile);
    }
}
