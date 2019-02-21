package com.dungnb.gem.projectcore.screen.questions_history;

import com.dungnb.gem.projectcore.base.pattern_viper.fragment.BaseFragmentContract;
import com.dungnb.gem.projectcore.pojo.model.Question;

import java.util.ArrayList;
import java.util.List;

public interface QuestionFragmentContract {
  interface View extends BaseFragmentContract.View<Presenter> {
    void fetchQuestionsSuccess(ArrayList<Question> questions);

    void fetchQuestionsError(String message_error);
  }

  interface Presenter extends BaseFragmentContract.Presenter<View, Interactor> {
    void fetchQuestions();

    void fetchQuestionsSuccess(ArrayList<Question> questions);

    void fetchQuestionsError(String message_error);

  }

  interface Interactor extends BaseFragmentContract.Interactor<Presenter> {
    void fetchQuestions();
  }

}
