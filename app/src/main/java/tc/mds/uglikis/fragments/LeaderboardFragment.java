
	 
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

import org.w3c.dom.Text;

import java.util.LinkedList;
import java.util.List;

import tc.mds.uglikis.R;
import tc.mds.uglikis.adapter.LeaderboardListAdapter;
import tc.mds.uglikis.model.Profile;

	public class LeaderboardFragment extends Fragment {

		//Leaderboard ViewItems
		private ImageView leaderboardFirstProfilePic;
		private ImageView leaderboardSecondProfilePic;
		private ImageView leaderboardThirdProfilePic;
		private TextView leaderboardFirstTag;
		private TextView leaderboardSecondTag;
		private TextView leaderboardThirdTag;
		private TextView leaderboardFirstPoints;
		private TextView leaderboardSecondPoints;
		private TextView leaderboardThirdPoints;
		private RecyclerView leaderboardList;



		public LeaderboardFragment() {

		}


		@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		 View rootView = inflater.inflate(R.layout.fragment_leaderboard, container, false);

		leaderboardFirstProfilePic = (ImageView) rootView.findViewById(R.id.first_profile_pic);
		leaderboardSecondProfilePic = (ImageView) rootView.findViewById(R.id.second_profile_pic);
		leaderboardThirdProfilePic = (ImageView) rootView.findViewById(R.id.third_profile_pic);
		leaderboardFirstTag = (TextView) rootView.findViewById(R.id.first_leader_tag);
		leaderboardSecondTag = (TextView) rootView.findViewById(R.id.second_leader_tag);
		leaderboardThirdTag = (TextView) rootView.findViewById(R.id.third_leader_tag);
		leaderboardFirstPoints = (TextView) rootView.findViewById(R.id.first_leader_points);
		leaderboardSecondPoints = (TextView) rootView.findViewById(R.id.second_leader_points);
		leaderboardThirdPoints = (TextView) rootView.findViewById(R.id.third_leader_points);
		leaderboardList = (RecyclerView) rootView.findViewById(R.id.leaderboard_list);

		//dummy Data for now
		List<Profile> profiles = new LinkedList<Profile>();
		for (int i = 0; i < 10; i++){
			Profile profile = new Profile("some username", "@example_tag");
			profile.setPoints(1200 - i);
			profiles.add(profile);
		}



		leaderboardList.setLayoutManager(new LinearLayoutManager(getActivity()));

		int scrollPosition = 0;
		scrollPosition = ((LinearLayoutManager) leaderboardList.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
		leaderboardList.scrollToPosition(scrollPosition);
		leaderboardList.setAdapter(new LeaderboardListAdapter(profiles));
		DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(leaderboardList.getContext(),((LinearLayoutManager) leaderboardList.getLayoutManager()).getOrientation());
		dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.divider_leaderboard_list));
		leaderboardList.addItemDecoration(dividerItemDecoration);

		return rootView;
	}

}
	
	