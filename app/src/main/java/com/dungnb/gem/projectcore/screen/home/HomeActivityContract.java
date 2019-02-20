package com.dungnb.gem.projectcore.screen.home;

import com.dungnb.gem.projectcore.base.pattern_viper.activity.BaseActivityContract;
import com.dungnb.gem.projectcore.pojo.model.Question;

import java.util.List;

public interface HomeActivityContract {
  interface View extends BaseActivityContract.View<Presenter> {


  }

  interface Presenter extends BaseActivityContract.Presenter<View, Interactor> {

  }

  interface Interactor extends BaseActivityContract.Interactor<Presenter> {

  }
}
