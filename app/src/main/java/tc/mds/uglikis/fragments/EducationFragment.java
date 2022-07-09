package tc.mds.uglikis.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.stream.Collectors;

import tc.mds.uglikis.R;
import tc.mds.uglikis.adapter.ArticleRecyclerViewAdapter;
import tc.mds.uglikis.model.Article;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EducationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EducationFragment extends Fragment {

    private RecyclerView articleRecyclerView;
    private TextView searchText;
    private ArticleRecyclerViewAdapter adapter;
    public static List<Article> articleList = new LinkedList<Article>();

    public EducationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EducationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EducationFragment newInstance() {
        EducationFragment fragment = new EducationFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_education, container, false);

        articleRecyclerView = view.findViewById(R.id.articles_list);
        searchText = view.findViewById(R.id.search_editText);

        List<Article> articleList = new LinkedList<Article>();

        for (int i = 0; i < 4; i++){
            articleList.add(new Article("Hydrogen cars " + i, "Patrick Zintel", "They are fun, but the technology probably isn't quite fully there yet. In terms of reach, better than electric cars though.", null, "No Content"));
        }

        articleRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ArticleRecyclerViewAdapter(articleList);
        articleRecyclerView.setAdapter(adapter);

        searchText.addTextChangedListener(new TextWatcher() {

            List<Article> articles = articleList;

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

                // filter your list from your input
                updateListForSearch(s.toString());
                //you can use runnable postDelayed like 500 ms to delay search text
            }


            public void updateListForSearch(String search){
                adapter.updateListSearch(articleList.stream().filter(x -> (x.getHeading().toLowerCase().contains(search.toLowerCase())) |
                        (x.getSummary().toLowerCase().contains(search.toLowerCase()))).collect(Collectors.toList()));
            }

        });


        return view;
    }
}