package com.dungnb.gem.projectcore.screen.search_history;

import android.annotation.SuppressLint;

import com.dungnb.gem.projectcore.base.pattern_viper.fragment.BaseFragmentInteractor;
import com.dungnb.gem.projectcore.pojo.model.Search;
import com.dungnb.gem.projectcore.webservice.content.ProjectRespository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@SuppressLint("CheckResult")
public class SearchFragmentInteractor
        extends BaseFragmentInteractor<SearchFragmentContract.Presenter>
        implements SearchFragmentContract.Interactor {

  @Override
  public void fetchSearch() {
    ProjectRespository.fetchSearches("desc", "activity", "Android", "stackoverflow")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(searches -> {
              getPresenter().fetchSearchSuccess((ArrayList<Search>) searches);
            }, throwable -> getPresenter().fetchSearchError());
  }
}
