package tc.mds.uglikis.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import tc.mds.uglikis.R;
import tc.mds.uglikis.SpecificActivitiesActivity;
import tc.mds.uglikis.model.Activity;
import tc.mds.uglikis.model.ActivityType;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Activity}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ActivityRecyclerViewAdapter extends RecyclerView.Adapter<ActivityRecyclerViewAdapter.ViewHolder> {

    private List<Activity> mValues;
    private ActivityType activityType;

    public ActivityRecyclerViewAdapter(List<Activity> items, ActivityType type) {
        mValues = items.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
        activityType = type;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activities_list_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ActivityRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.setItem(mValues.get(position));
        holder.getTitle().setText(holder.getItem().getName());
        holder.getDescription1().setText(holder.getItem().getDescription());
        holder.getDescription2().setText(holder.getItem().rewardRateString());
        switch (holder.getItem().getType()){
            case Nutrition:
                holder.splashart.setImageResource(R.drawable.food__shopping___groceries__grocery__organic__shop__store__fruit__vegetable__bread);
                break;
            case Mobility:
                holder.splashart.setImageResource(R.drawable.ecology__transportation___electricity__car__vehicle__transport__automobile__eco_friendly__electric_ek1);
                break;
            case Waste:
                holder.splashart.setImageResource(R.drawable.delete__ecology___trash__bin__garbage__remove__recycle__recycling_ek1);
                break;
        }

        // set ongoingWidget to Green if ongoing
        if (holder.getItem().getOngoing() == true) {
            // set widget
            holder.getOngoingWidget().setText("Ongoing");
        } else holder.getOngoingWidget().setText("");

        // Add onclick listener to open SpecificActivityFragment

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                android.util.Log.d("black", "onclick inside recyclerAdapter");
                // use MainActivity.java logic with beginTransaction for fragment
                //Intent nextScreen = new Intent(v.getContext(), SpecificActivitiesActivity.class);
                Intent nextScreen = new Intent(v.getContext(), SpecificActivitiesActivity.class);
                nextScreen.putExtra("rewardRate", holder.getItem().getRewardRate());
                nextScreen.putExtra("title", holder.getItem().getName());
                int aType = 0;
                switch(holder.getItem().getType()){
                    case Waste:
                        aType = 0;
                        break;
                    case Mobility:
                        aType = 1;
                        break;
                    case Nutrition:
                        aType = 2;
                        break;
                }
                nextScreen.putExtra("activityType", aType);
                v.getContext().startActivity(nextScreen);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView description1;
        private final TextView description2;
        private final ImageView splashart;
        private final TextView ongoingWidget;

        private Activity mItem;

        public ViewHolder(View view) {
            super(view);

            this.title = view.findViewById(R.id.article_list_item_title);
            this.description1 = view.findViewById(R.id.article_list_item_description);
            this.description2 = view.findViewById(R.id.activity_list_item_desc2);
            this.ongoingWidget = view.findViewById(R.id.activity_list_item_ongoingW);
            this.splashart = view.findViewById(R.id.article_list_item_splashart);
        }

        public void setItem(Activity mItem) {
            this.mItem = mItem;
        }

        public Activity getItem() {
            return mItem;
        }

        public TextView getTitle() {
            return title;
        }

        public TextView getOngoingWidget() { return this.ongoingWidget; }

        public TextView getDescription1() {
            return description1;
        }

        public TextView getDescription2() {
            return description2;
        }

        public ImageView getSplashart() {
            return splashart;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + title.getText() + "'";
        }
    }
}