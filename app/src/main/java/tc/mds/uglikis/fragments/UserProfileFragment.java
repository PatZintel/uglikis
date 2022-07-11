
	 
	/*
     *	This content is generated from the API File Info.
     *	(Alt+Shift+Ctrl+I).
     *
     *	@desc
     *	@file 		leaderboard
     *	@date 		1656763971545
     *	@title 		Leaderboard
     *	@author
     *	@keywords
     *	@generator 	Export Kit v1.3.figma
     *
     */


    package tc.mds.uglikis.fragments;

    import android.os.Bundle;


    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ImageView;
    import android.widget.TextView;

    import androidx.core.content.ContextCompat;
    import androidx.fragment.app.Fragment;
    import androidx.recyclerview.widget.DividerItemDecoration;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import org.json.JSONArray;
    import org.json.JSONObject;

    import java.util.LinkedList;
    import java.util.List;

    import tc.mds.uglikis.R;
    import tc.mds.uglikis.adapter.LeaderboardListAdapter;
    import tc.mds.uglikis.adapter.ProfileStatementsListAdapter;
    import tc.mds.uglikis.model.Profile;

    public class UserProfileFragment extends Fragment {

        //Leaderboard ViewItems
        private ImageView profilePic;
        private RecyclerView profileStatements_list;



        public UserProfileFragment() {

        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

            profileStatements_list = (RecyclerView) rootView.findViewById(R.id.profileStatements_list);

            //dummy Data for now

            // add stuff
            List<String> tags = new LinkedList<>();
            List<String> statements = new LinkedList<>();;

            tags.add("You currently have 420 UC points");
            statements.add("Pro");

           /* while(keys.hasNext()) {
                String key = keys.next();
                if (jsonObj.get(key) instanceof JSONObject) {
                    // do something with jsonObject here
                }
            }
            List<Profile> profiles = new LinkedList<Profile>();
            for (int i = 0; i < 10; i++){
                Profile profile = new Profile("some username", "@example_tag");
                profile.setPoints(1200 - i);
                profiles.add(profile);
            }
*/


            profileStatements_list.setLayoutManager(new LinearLayoutManager(getActivity()));

            int scrollPosition = 0;
            scrollPosition = ((LinearLayoutManager) profileStatements_list.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
            profileStatements_list.scrollToPosition(scrollPosition);
            profileStatements_list.setAdapter(new ProfileStatementsListAdapter(statements, tags));
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(profileStatements_list.getContext(),((LinearLayoutManager) profileStatements_list.getLayoutManager()).getOrientation());
            dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.divider_leaderboard_list));
            profileStatements_list.addItemDecoration(dividerItemDecoration);

            return rootView;
        }

    }
	
	