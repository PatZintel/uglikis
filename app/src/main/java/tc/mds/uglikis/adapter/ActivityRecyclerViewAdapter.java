package tc.mds.uglikis.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;

import java.util.List;

import tc.mds.uglikis.R;
import tc.mds.uglikis.SpecificActivitiesActivity;
import tc.mds.uglikis.model.Activity;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Activity}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ActivityRecyclerViewAdapter extends RecyclerView.Adapter<ActivityRecyclerViewAdapter.ViewHolder> {

    private List<Activity> mValues;


    public ActivityRecyclerViewAdapter(List<Activity> items) {
        mValues = items;
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
        holder.getDescription2().setText(holder.getItem().getRewardRate());

        // Add onclick listener to open SpecificActivityFragment

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                android.util.Log.d("black","onclick inside recyclerAdapter");
                // use MainActivity.java logic with beginTransaction for fragment
                Intent nextScreen = new Intent(v.getContext(), SpecificActivitiesActivity.class);
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

        private Activity mItem;

        public ViewHolder(View view) {
            super(view);

            this.title = view.findViewById(R.id.article_list_item_title);
            this.description1 = view.findViewById(R.id.article_list_item_description);
            this.description2 = view.findViewById(R.id.activity_list_item_desc2);
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