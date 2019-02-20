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
  public void fetchSearch() {
    getInteractor().fetchSearch();
  }

  @Override
  public void fetchSearchSuccess(ArrayList<Search> searches) {
    getView().updateUI(searches);
  }

  @Override
  public void fetchSearchError() {
    getView().showError();
  }


}
