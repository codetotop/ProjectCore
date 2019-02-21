package com.dungnb.gem.projectcore.screen.search_history;

import com.dungnb.gem.projectcore.base.pattern_viper.fragment.BaseFragmentPresenter;
import com.dungnb.gem.projectcore.pojo.model.Search;

import java.util.ArrayList;

public class SearchFragmentPresenter
        extends BaseFragmentPresenter<SearchFragmentContract.View, SearchFragmentContract.Interactor>
        implements SearchFragmentContract.Presenter {

  @Override
  public SearchFragmentContract.View createView() {
    return SearchFragment.getInstance();
  }

  @Override
  public SearchFragmentContract.Interactor createInteractor() {
    return new SearchFragmentInteractor();
  }

  @Override
  public void fetchSearches() {
    getInteractor().fetchSearches();
  }

  @Override
  public void fetchSearchesSuccess(ArrayList<Search> searches) {
    getView().fetchSearchesSuccess(searches);
  }

  @Override
  public void fetchSearchesError(String message_error) {
    getView().fetchSearchesError(message_error);
  }


}
