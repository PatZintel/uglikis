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

public class ProfileStatementsListAdapter extends RecyclerView.Adapter<ProfileStatementsListAdapter.ViewHolder> {

    //    private List<Profile> profileStatements;
    private List<String> statementList;
    private List<String> tagList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView profileStatementListItemTag;
        private final TextView profileStatementListItemStatement;
//        private final ImageView profileStatementListItemPicture;


        public TextView getProfileStatementListItemStatement() {
            return profileStatementListItemStatement;
        }

//        public ImageView getProfileStatementListItemPicture() {
//            return profileStatementListItemPicture;
//        }

        public TextView getProfileStatementListItemTag() {
            return profileStatementListItemTag;
        }

        public ViewHolder(View view) {
            super(view);


            this.profileStatementListItemTag = view.findViewById(R.id.profileStatement_list_item_tag);
            this.profileStatementListItemStatement = view.findViewById(R.id.profileStatement_list_item_statement);
//            this.profileStatementListItemPicture = view.findViewById(R.id.profileStatement_list_item_picture);
        }

    }

    public ProfileStatementsListAdapter(List<String> statementList, List<String> tagList) {
        this.statementList = statementList;
        this.tagList = tagList;
    }

    @NonNull
    @Override
    public ProfileStatementsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profilestatement_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileStatementsListAdapter.ViewHolder holder, int position) {
        holder.getProfileStatementListItemStatement().setText(statementList.get(position));
        holder.getProfileStatementListItemTag().setText(tagList.get(position));
//        holder.getProfileStatementListItemStanding().setText(String.valueOf(position+4));
    }

    @Override
    public int getItemCount() {
        return statementList.size();
    }
}
