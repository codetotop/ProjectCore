package com.dungnb.gem.projectcore.screen.search_history;

import com.dungnb.gem.projectcore.base.pattern_viper.fragment.BaseFragmentContract;
import com.dungnb.gem.projectcore.pojo.model.Search;

import java.util.ArrayList;

public interface SearchFragmentContract {
  interface View extends BaseFragmentContract.View<Presenter> {
    void fetchSearchesSuccess(ArrayList<Search> searches);

    void fetchSearchesError(String message_error);
  }

  interface Presenter extends BaseFragmentContract.Presenter<View, Interactor> {

    void fetchSearches();

    void fetchSearchesSuccess(ArrayList<Search> searches);

    void fetchSearchesError(String message_error);
  }

  interface Interactor extends BaseFragmentContract.Interactor<Presenter> {
    void fetchSearches();
  }
}
