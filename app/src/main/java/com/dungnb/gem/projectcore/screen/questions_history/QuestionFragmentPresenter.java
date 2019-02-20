package com.dungnb.gem.projectcore.screen.questions_history;

import com.dungnb.gem.projectcore.base.pattern_viper.fragment.BaseFragmentPresenter;
import com.dungnb.gem.projectcore.pojo.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionFragmentPresenter
        extends BaseFragmentPresenter<QuestionFragmentContract.View, QuestionFragmentContract.Interactor>
        implements QuestionFragmentContract.Presenter {

  @Override
  public QuestionFragmentContract.View createView() {
    return new QuestionFragment();
  }

  @Override
  public QuestionFragmentContract.Interactor createInteractor() {
    return new QuestionFragmentInteractor();
  }

  @Override
  public void fetchQuestion() {
    getInteractor().fetchQuestion();
  }

  @Override
  public void fetchQuestionSuccess(ArrayList<Question> questions) {
    getView().updateUI(questions);
  }

  @Override
  public void fetchQuestionError() {
    getView().showError();
  }

}
