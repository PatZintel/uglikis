package tc.mds.uglikis.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import tc.mds.uglikis.R;
import tc.mds.uglikis.adapter.ActivityRecyclerViewAdapter;
import tc.mds.uglikis.model.Activity;
import tc.mds.uglikis.model.ActivityType;

/**
 * A fragment representing a list of Items.
 */
public class ActivityFragment extends Fragment {


    private RecyclerView mobilityActivityList;
    private RecyclerView nutritionActivityList;
    private RecyclerView wasteActivityList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activities_home_screen, container, false);

        mobilityActivityList = view.findViewById(R.id.mobility_activities_list);
        wasteActivityList = view.findViewById(R.id.waste_activities_list);
        nutritionActivityList = view.findViewById(R.id.nutrition_activities_list);

        List<Activity> activities = new LinkedList<Activity>();
        for (int i = 0; i < 4; i++) {
            activities.add(new Activity(i * 3, ActivityType.Mobility, "Riding the bike " + i,
                    "Save CO2 by riding the bike instead of the car", 5));
            activities.add(new Activity(i * 3 + 1, ActivityType.Waste, "Recycle properly " + i,
                    "Save CO2 by properly recycling your waste so it won't get burnt", 1));
            activities.add(new Activity(i * 3 + 2, ActivityType.Nutrition, "Eating meatless " + i,
                    "Save CO2 by avoiding meat in your food", 2));
        }

        // Set the adapter
        LinearLayoutManager layoutManagerMobilityList = new LinearLayoutManager(getActivity());
        layoutManagerMobilityList.setOrientation(RecyclerView.HORIZONTAL);
        mobilityActivityList.setLayoutManager(layoutManagerMobilityList);
        mobilityActivityList.setAdapter(new ActivityRecyclerViewAdapter(activities.stream()
                .filter(x -> x.getType().equals(ActivityType.Mobility)).collect(Collectors.toList())));
        LinearLayoutManager layoutManagerWasteList = new LinearLayoutManager(getActivity());
        layoutManagerWasteList.setOrientation(RecyclerView.HORIZONTAL);
        wasteActivityList.setLayoutManager(layoutManagerWasteList);
        wasteActivityList.setAdapter(new ActivityRecyclerViewAdapter(activities.stream()
                .filter(x -> x.getType().equals(ActivityType.Waste)).collect(Collectors.toList())));
        LinearLayoutManager layoutManagerNutritionList = new LinearLayoutManager(getActivity());
        layoutManagerNutritionList.setOrientation(RecyclerView.HORIZONTAL);
        nutritionActivityList.setLayoutManager(layoutManagerNutritionList);
        nutritionActivityList.setAdapter(new ActivityRecyclerViewAdapter(activities.stream()
                .filter(x -> x.getType().equals(ActivityType.Nutrition)).collect(Collectors.toList())));
        return view;
    }
}