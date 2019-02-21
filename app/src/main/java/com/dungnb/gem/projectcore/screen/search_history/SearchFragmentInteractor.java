package com.dungnb.gem.projectcore.screen.search_history;

import android.annotation.SuppressLint;

import com.dungnb.gem.projectcore.base.pattern_viper.fragment.BaseFragmentInteractor;
import com.dungnb.gem.projectcore.pojo.model.Search;
import com.dungnb.gem.projectcore.webservice.content.ProjectRespository;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@SuppressLint("CheckResult")
public class SearchFragmentInteractor
        extends BaseFragmentInteractor<SearchFragmentContract.Presenter>
        implements SearchFragmentContract.Interactor {

  @Override
  public void fetchSearches() {
    ProjectRespository.fetchSearches("desc", "activity", "Android", "stackoverflow")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(searches -> {
              getPresenter().fetchSearchesSuccess((ArrayList<Search>) searches);
            }, throwable -> getPresenter().fetchSearchesError("Have error !"));
  }
}
