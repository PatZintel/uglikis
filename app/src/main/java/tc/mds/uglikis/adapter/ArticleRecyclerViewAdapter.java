package tc.mds.uglikis.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.stream.Collectors;

import kotlin.text.UStringsKt;
import tc.mds.uglikis.R;
import tc.mds.uglikis.model.Activity;
import tc.mds.uglikis.model.Article;

public class ArticleRecyclerViewAdapter extends RecyclerView.Adapter<ArticleRecyclerViewAdapter.ViewHolder> {


    private List<Article> mValues;

    public ArticleRecyclerViewAdapter(List<Article> items) {
        mValues = items;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.articles_list_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItem(mValues.get(position));
        holder.getTitle().setText(holder.getItem().getHeading());
        holder.getSummary().setText(holder.getItem().getSummary());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void updateListSearch(List<Article> list){
        mValues = list;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView summary;
        private final ImageView splashart;

        private Article mItem;

        public ViewHolder(View view) {
            super(view);

            this.title = view.findViewById(R.id.article_list_item_title);
            this.summary = view.findViewById(R.id.article_list_item_description);
            this.splashart = view.findViewById(R.id.article_list_item_splashart);
        }

        public void setItem(Article mItem) {
            this.mItem = mItem;
        }

        public Article getItem() {
            return mItem;
        }

        public TextView getTitle() {
            return title;
        }

        public TextView getSummary() {
            return summary;
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
