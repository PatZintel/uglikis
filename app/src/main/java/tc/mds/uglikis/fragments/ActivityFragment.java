package tc.mds.uglikis.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import tc.mds.uglikis.KnowledgeBase;
import tc.mds.uglikis.MainActivity;
import tc.mds.uglikis.R;
import tc.mds.uglikis.adapter.ActivityRecyclerViewAdapter;
import tc.mds.uglikis.model.Activity;
import tc.mds.uglikis.model.ActivityType;

/**
 * A fragment representing a list of Items.
 */
public class ActivityFragment extends Fragment implements LoadedFragment {


    private RecyclerView mobilityActivityList;
    private RecyclerView nutritionActivityList;
    private RecyclerView wasteActivityList;
    private ActivityRecyclerViewAdapter mobilityAdapter;
    private ActivityRecyclerViewAdapter wasteAdapter;
    private ActivityRecyclerViewAdapter nutritionAdapter;
    private KnowledgeBase knowledgeBase;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ActivityFragment() {
    }

    public void notifyDatasetChanged(){
        mobilityAdapter.notifyDataSetChanged();
        wasteAdapter.notifyDataSetChanged();
        nutritionAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activities_home_screen, container, false);

        knowledgeBase = ((MainActivity) getActivity()).knowledgeBase;

        mobilityActivityList = view.findViewById(R.id.mobility_activities_list);
        wasteActivityList = view.findViewById(R.id.waste_activities_list);
        nutritionActivityList = view.findViewById(R.id.nutrition_activities_list);
/*

        List<Activity> activities = new LinkedList<Activity>();
        activities.add(new Activity(0, ActivityType.Mobility, "Riding the bike",
                "Save CO2 by riding the bike instead of the car", 5));
        activities.add(new Activity(1, ActivityType.Waste, "Recycle properly",
                "Save CO2 by properly recycling your waste so it won't get burnt", 1));
        activities.add(new Activity(2, ActivityType.Nutrition, "Eat your own produce",
                "Save CO2 diminishing transport of your food", 4));
        activities.add(new Activity(3, ActivityType.Mobility, "Walking instead of driving",
                "Save CO2 by riding the bike instead of the car", 5));
        activities.add(new Activity(4, ActivityType.Waste, "Recycle properly",
                "Save CO2 by properly recycling your waste so it won't get burnt", 1));
        activities.add(new Activity(5, ActivityType.Nutrition, "Eating meatless",
                "Save CO2 by avoiding meat in your food", 2));
        activities.add(new Activity(6, ActivityType.Mobility, "Use public transport",
                "Reduce your CO2 emissions by using public transport instead of the car", 2));
        activities.add(new Activity(7, ActivityType.Waste, "Compost",
                "Save CO2 by compost your Bio waste yourself for fertilizer", 1));
        activities.add(new Activity(8, ActivityType.Nutrition, "Eat seasonal produce",
                "Save CO2 reducing transport amounts of your food", 2));

        for (Activity activity : activities) {
            knowledgeBase.saveActivity(activity);
        }
*/

        // Set the adapter
        LinearLayoutManager layoutManagerMobilityList = new LinearLayoutManager(getActivity());
        layoutManagerMobilityList.setOrientation(RecyclerView.HORIZONTAL);
        mobilityActivityList.setLayoutManager(layoutManagerMobilityList);
        mobilityAdapter = new ActivityRecyclerViewAdapter(knowledgeBase.getActivities(), ActivityType.Mobility);
        mobilityActivityList.setAdapter(mobilityAdapter);
        LinearLayoutManager layoutManagerWasteList = new LinearLayoutManager(getActivity());
        layoutManagerWasteList.setOrientation(RecyclerView.HORIZONTAL);
        wasteActivityList.setLayoutManager(layoutManagerWasteList);
        wasteAdapter = new ActivityRecyclerViewAdapter(knowledgeBase.getActivities(), ActivityType.Waste);
        wasteActivityList.setAdapter(wasteAdapter);
        LinearLayoutManager layoutManagerNutritionList = new LinearLayoutManager(getActivity());
        layoutManagerNutritionList.setOrientation(RecyclerView.HORIZONTAL);
        nutritionActivityList.setLayoutManager(layoutManagerNutritionList);
        nutritionAdapter = new ActivityRecyclerViewAdapter(knowledgeBase.getActivities(), ActivityType.Nutrition);
        nutritionActivityList.setAdapter(nutritionAdapter);
        return view;
    }
}