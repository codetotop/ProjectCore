package com.dungnb.gem.projectcore.screen.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dungnb.gem.projectcore.R;
import com.dungnb.gem.projectcore.pojo.model.Search;

import java.util.ArrayList;
@SuppressLint("SetTextI18n")
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> {
  ArrayList<Search> mSearches;
  Context mContext;

  public SearchAdapter(Context context, ArrayList<Search> searches) {
    mSearches = searches;
    mContext = context;
  }

  @NonNull
  @Override
  public SearchHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.item_search, viewGroup, false);
    return new SearchHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull SearchHolder searchHolder, int i) {
    Search search = mSearches.get(i);
    searchHolder.mTvSearch.setText(mContext.getString(R.string.question_title) + " " + search.getTitle());
  }

  @Override
  public int getItemCount() {
    return mSearches.size();
  }

  public void refreshList(ArrayList<Search> searches) {
    mSearches.clear();
    mSearches.addAll(searches);
    notifyDataSetChanged();
  }

  class SearchHolder extends RecyclerView.ViewHolder {
    TextView mTvSearch;

    public SearchHolder(@NonNull View itemView) {
      super(itemView);
      mTvSearch = itemView.findViewById(R.id.tvSearch);
    }
  }
}
