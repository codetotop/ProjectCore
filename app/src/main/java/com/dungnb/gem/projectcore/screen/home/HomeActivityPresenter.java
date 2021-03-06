package com.dungnb.gem.projectcore.screen.home;

import com.dungnb.gem.projectcore.base.pattern_viper.activity.BaseActivityPresenter;
import com.dungnb.gem.projectcore.pojo.model.Question;

import java.util.List;

public class HomeActivityPresenter extends BaseActivityPresenter<HomeActivityContract.View, HomeActivityContract.Interactor>
        implements HomeActivityContract.Presenter {
  @Override
  public HomeActivityContract.Interactor createInteractor() {
    return new HomeActivityInteractor();
  }
}
