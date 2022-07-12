
	 
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

    import androidx.core.content.ContextCompat;
    import androidx.fragment.app.Fragment;
    import androidx.recyclerview.widget.DividerItemDecoration;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import tc.mds.uglikis.R;
    import tc.mds.uglikis.adapter.ProfileStatementsListAdapter;

    public class UserProfileFragment extends Fragment implements LoadedFragment {

        private ImageView profilePic;
        private RecyclerView profileStatements_list;
        private ProfileStatementsListAdapter adapter;


        public UserProfileFragment() {

        }


        public void notifyDatasetChanged(){
            adapter.notifyDataSetChanged();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_profile, container, false);



            profileStatements_list = (RecyclerView) rootView.findViewById(R.id.profileStatements_list);


            String[] statements = {"You currently have 420 UC points", "You're great at bike and EV use!"};
            String[] tags = {"Pro!",""};


            profileStatements_list.setLayoutManager(new LinearLayoutManager(getActivity()));

            int scrollPosition = 0;
            scrollPosition = ((LinearLayoutManager) profileStatements_list.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
            profileStatements_list.scrollToPosition(scrollPosition);
            adapter = new ProfileStatementsListAdapter(statements, tags);
            profileStatements_list.setAdapter(adapter);
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(profileStatements_list.getContext(), ((LinearLayoutManager) profileStatements_list.getLayoutManager()).getOrientation());
            dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.divider_leaderboard_list));
            profileStatements_list.addItemDecoration(dividerItemDecoration);

            return rootView;
        }

    }
	
	