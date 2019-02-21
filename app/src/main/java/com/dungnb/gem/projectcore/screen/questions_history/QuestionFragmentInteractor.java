package com.dungnb.gem.projectcore.screen.questions_history;

import android.annotation.SuppressLint;

import com.dungnb.gem.projectcore.base.pattern_viper.fragment.BaseFragmentInteractor;
import com.dungnb.gem.projectcore.pojo.model.Question;
import com.dungnb.gem.projectcore.webservice.content.ProjectRespository;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@SuppressLint("CheckResult")
public class QuestionFragmentInteractor
        extends BaseFragmentInteractor<QuestionFragmentContract.Presenter>
        implements QuestionFragmentContract.Interactor {

  @Override
  public void fetchQuestions() {
    ProjectRespository.fetchQuestions("desc", "activity", "Android", "stackoverflow")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(questions -> {
              getPresenter().fetchQuestionsSuccess((ArrayList<Question>) questions);
            }, throwable -> {
              getPresenter().fetchQuestionsError("Have error !");
            });
  }
}
