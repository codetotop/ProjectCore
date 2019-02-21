package com.dungnb.gem.projectcore.screen.questions_history;

import com.dungnb.gem.projectcore.base.pattern_viper.fragment.BaseFragmentPresenter;
import com.dungnb.gem.projectcore.pojo.model.Question;

import java.util.ArrayList;

public class QuestionFragmentPresenter
        extends BaseFragmentPresenter<QuestionFragmentContract.View, QuestionFragmentContract.Interactor>
        implements QuestionFragmentContract.Presenter {

  @Override
  public QuestionFragmentContract.View createView() {
    return QuestionFragment.getInstance();
  }

  @Override
  public QuestionFragmentContract.Interactor createInteractor() {
    return new QuestionFragmentInteractor();
  }

  @Override
  public void fetchQuestions() {
    getInteractor().fetchQuestions();
  }

  @Override
  public void fetchQuestionsSuccess(ArrayList<Question> questions) {
    getView().fetchQuestionsSuccess(questions);
  }

  @Override
  public void fetchQuestionsError(String message_error) {
    getView().fetchQuestionsError(message_error);
  }

}
