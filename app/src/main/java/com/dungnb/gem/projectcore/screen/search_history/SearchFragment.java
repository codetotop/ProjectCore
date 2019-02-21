package com.dungnb.gem.projectcore.screen.search_history;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.dungnb.gem.projectcore.R;
import com.dungnb.gem.projectcore.base.pattern_viper.fragment.BaseFragment;
import com.dungnb.gem.projectcore.pojo.model.Search;
import com.dungnb.gem.projectcore.screen.adapter.SearchAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

public class SearchFragment
        extends BaseFragment<SearchFragmentContract.Presenter>
        implements SearchFragmentContract.View {
  private static SearchFragment mInstance;
  @BindView(R.id.rcvSearch)
  SuperRecyclerView mRcvSearch;
  ArrayList<Search> mSearches;
  SearchAdapter mSearchAdapter;

  public static SearchFragment getInstance() {
    if (mInstance == null)
      mInstance = new SearchFragment();
    return mInstance;
  }

  @Override
  protected int getLayoutResourceID() {
    return R.layout.fragment_search;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    setUpView();
  }

  @Override
  public void onResume() {
    super.onResume();
    getData();
  }

  private void getData() {
    getPresenter().fetchSearches();
  }

  private void setUpView() {
    mRcvSearch.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    mSearches = new ArrayList<>();
    mSearchAdapter = new SearchAdapter(getContext(), mSearches);
    mRcvSearch.setAdapter(mSearchAdapter);
  }

  @Override
  public void fetchSearchesSuccess(ArrayList<Search> searches) {
    mSearchAdapter.refreshList(searches);
  }

  @Override
  public void fetchSearchesError(String message_error) {
    Toast.makeText(getContext(), message_error, Toast.LENGTH_SHORT).show();
  }
}
