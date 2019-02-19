package com.dungnb.gem.projectcore.screen.home;

import com.dungnb.gem.projectcore.base.pattern_viper.activity.BaseActivityContract;
import com.dungnb.gem.projectcore.pojo.model.Question;

import java.util.List;

public interface HomeActivityContract {
  interface View extends BaseActivityContract.View<Presenter> {

    void updateUI(List<Question> questions);

    void showError();
  }

  interface Presenter extends BaseActivityContract.Presenter<View, Interactor> {
     void getQuestion();

    void fetchQuestionSuccess(List<Question> questions);

    void fetchQuestionError();
  }

  interface Interactor extends BaseActivityContract.Interactor<Presenter> {

    void fetchQuestion();
  }
}
