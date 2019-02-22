package com.dungnb.gem.projectcore.screen.answer_history;

import com.dungnb.gem.projectcore.base.pattern_mvp.fragment.BaseFragmentContract;
import com.dungnb.gem.projectcore.pojo.model.Answer;

import java.util.ArrayList;

public interface AnswerFragmentContract {
  interface View extends BaseFragmentContract.View<Presenter> {
    void fetchAnswersSuccess(ArrayList<Answer> answers);

    void fetchError(String message_error);
  }

  interface Presenter extends BaseFragmentContract.Presenter<View> {
    void fetchAnswers();
  }
}
