package com.dungnb.gem.projectcore.screen.home;

import android.annotation.SuppressLint;

import com.dungnb.gem.projectcore.base.pattern_viper.activity.BaseActivityInteractor;
import com.dungnb.gem.projectcore.webservice.content.ProjectRespository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@SuppressLint("CheckResult")
public class HomeActivityInteractor
        extends BaseActivityInteractor<HomeActivityContract.Presenter>
        implements HomeActivityContract.Interactor {
  public HomeActivityInteractor(HomeActivityContract.Presenter presenter) {
    super(presenter);
  }


}
