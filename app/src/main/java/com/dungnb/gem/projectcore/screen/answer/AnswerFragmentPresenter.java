package com.dungnb.gem.projectcore.screen.answer;

import android.annotation.SuppressLint;

import com.dungnb.gem.projectcore.base.pattern_mvp.fragment.BaseFragmentPresenter;
import com.dungnb.gem.projectcore.pojo.model.Answer;
import com.dungnb.gem.projectcore.webservice.content.ProjectRespository;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@SuppressLint("CheckResult")
public class AnswerFragmentPresenter
        extends BaseFragmentPresenter<AnswerFragmentContract.View> implements AnswerFragmentContract.Presenter {
  @Override
  public AnswerFragmentContract.View createView() {
    return AnswerFragment.getInstance();
  }

  @Override
  public void fetchAnswers() {
    ProjectRespository.fetchAnswers("desc", "activity", "stackoverflow")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(answers -> {
              getView().fetchAnswersSuccess((ArrayList<Answer>) answers);
            }, throwable -> {
              getView().showError();
              //getView().fetchError("Have Error !");
            });
  }
}
