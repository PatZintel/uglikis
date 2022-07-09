package tc.mds.uglikis.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tc.mds.uglikis.R;
import tc.mds.uglikis.model.Profile;

public class LeaderboardListAdapter extends RecyclerView.Adapter<LeaderboardListAdapter.ViewHolder>{

    private List<Profile> leaderboardProfilesAfterThree;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView leaderboardListItemTag;
        private final TextView leaderboardListItemPoints;
        private final TextView leaderboardListItemStanding;
        private final ImageView leaderboardListItemPicture;

        public TextView getLeaderboardListItemStanding() {
            return leaderboardListItemStanding;
        }


        public TextView getLeaderboardListItemPoints() {
            return leaderboardListItemPoints;
        }

        public ImageView getLeaderboardListItemPicture() {
            return leaderboardListItemPicture;
        }

        public TextView getLeaderboardListItemTag() {
            return leaderboardListItemTag;
        }

        public ViewHolder(View view) {
            super(view);

            this.leaderboardListItemStanding = view.findViewById(R.id.leaderboard_list_standing);
            this.leaderboardListItemTag = view.findViewById(R.id.leaderboard_list_item_tag);
            this.leaderboardListItemPoints = view.findViewById(R.id.leaderboard_list_item_points);
            this.leaderboardListItemPicture = view.findViewById(R.id.leaderboard_list_item_picture);
        }

    }

    public LeaderboardListAdapter(List<Profile> leaderboardProfilesAfterThree){
        this.leaderboardProfilesAfterThree = leaderboardProfilesAfterThree;
    }

    @NonNull
    @Override
    public LeaderboardListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardListAdapter.ViewHolder holder, int position) {
        holder.getLeaderboardListItemPoints().setText(String.valueOf(leaderboardProfilesAfterThree.get(position).getPoints()));
        holder.getLeaderboardListItemTag().setText(leaderboardProfilesAfterThree.get(position).getTag());
        holder.getLeaderboardListItemStanding().setText(String.valueOf(position+4));
    }

    @Override
    public int getItemCount() {
        return leaderboardProfilesAfterThree.size();
    }
}
