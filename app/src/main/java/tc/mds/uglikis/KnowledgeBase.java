package tc.mds.uglikis;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import java.util.Locale;

import tc.mds.uglikis.model.Activity;
import tc.mds.uglikis.model.Article;
import tc.mds.uglikis.model.Profile;

public class KnowledgeBase {

    private DatabaseReference database;

    private FirebaseUser activeUser;

    private Profile activeProfile;

    private List<Article> articles;

    private List<Activity> activities;

    private List<Profile> publicProfiles;

    public KnowledgeBase(String userId){
        database = FirebaseDatabase.getInstance("https://uglikis-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        activeUser = FirebaseAuth.getInstance().getCurrentUser();
        database.child("profiles").child(userId).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    activeProfile = (Profile) task.getResult().getValue();
                }
            }
        });
        if(activeProfile == null){
            activeProfile = new Profile(activeUser.getDisplayName(), activeUser.getDisplayName().toLowerCase());
            updateProfileOnDB(activeProfile);
        }


    }

    public Profile getActiveProfile() {
        return activeProfile;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void updateProfileOnDB(Profile profile){
        database.child("profiles").child(profile.getAuthUserId()).setValue(profile);
        Profile publicProfile = profile;
        database.child("publicProfiles").child(String.valueOf(profile.getAuthUserId())).setValue(publicProfile);
    }


}
