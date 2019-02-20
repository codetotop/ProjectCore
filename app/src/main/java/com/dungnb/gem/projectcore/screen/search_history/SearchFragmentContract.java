package com.dungnb.gem.projectcore.screen.search_history;

import com.dungnb.gem.projectcore.base.pattern_viper.fragment.BaseFragmentContract;
import com.dungnb.gem.projectcore.pojo.model.Search;

import java.util.ArrayList;

public interface SearchFragmentContract {
  interface View extends BaseFragmentContract.View<Presenter> {
    void updateUI(ArrayList<Search> searches);

    void showError();
  }

  interface Presenter extends BaseFragmentContract.Presenter<View, Interactor> {

    void fetchSearch();

    void fetchSearchSuccess(ArrayList<Search> searches);

    void fetchSearchError();
  }

  interface Interactor extends BaseFragmentContract.Interactor<Presenter> {
    void fetchSearch();
  }
}
