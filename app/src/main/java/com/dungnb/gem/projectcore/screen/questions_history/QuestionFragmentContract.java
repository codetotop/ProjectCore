package com.dungnb.gem.projectcore.screen.questions_history;

import com.dungnb.gem.projectcore.base.pattern_viper.fragment.BaseFragmentContract;
import com.dungnb.gem.projectcore.pojo.model.Question;

import java.util.ArrayList;
import java.util.List;

public interface QuestionFragmentContract {
  interface View extends BaseFragmentContract.View<Presenter> {
    void updateUI(ArrayList<Question> questions);

    void showError();
  }

  interface Presenter extends BaseFragmentContract.Presenter<View, Interactor> {
    void fetchQuestion();

    void fetchQuestionSuccess(ArrayList<Question> questions);

    void fetchQuestionError();

  }

  interface Interactor extends BaseFragmentContract.Interactor<Presenter> {
    void fetchQuestion();
  }

}
