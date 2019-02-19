package com.dungnb.gem.projectcore.screen.questions_history;

import com.dungnb.gem.projectcore.base.pattern_viper.fragment.BaseFragmentContract;

public interface QuestionHistoryFragmentContract {
  interface View extends BaseFragmentContract.View<Presenter> {

  }

  interface Presenter extends BaseFragmentContract.Presenter<View, Interactor> {

  }

  interface Interactor extends BaseFragmentContract.Interactor<Presenter> {

  }

}
