package com.dungnb.gem.projectcore.screen.home;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.dungnb.gem.projectcore.R;
import com.dungnb.gem.projectcore.base.pattern_viper.activity.BaseActivity;
import com.dungnb.gem.projectcore.screen.answer_history.AnswerFragment;
import com.dungnb.gem.projectcore.screen.answer_history.AnswerFragmentPresenter;
import com.dungnb.gem.projectcore.screen.questions_history.QuestionFragment;
import com.dungnb.gem.projectcore.screen.questions_history.QuestionFragmentPresenter;
import com.dungnb.gem.projectcore.screen.search_history.SearchFragment;
import com.dungnb.gem.projectcore.screen.search_history.SearchFragmentPresenter;

import butterknife.OnClick;

@SuppressLint("CheckResult")

public class HomeActivity extends BaseActivity<HomeActivityContract.Presenter> implements HomeActivityContract.View {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addControls();
  }

  @Override
  public int getLayoutResourceID() {
    return R.layout.activity_main;
  }

  @OnClick(R.id.btnGetQuestion)
  void getQuestion() {
    addOrShowChildrenFragment(R.id.containerFrame, new QuestionFragmentPresenter().getFragment(), null, false, QuestionFragment.class.getName());
  }

  @OnClick(R.id.btnGetSearch)
  void getSearch() {
    addOrShowChildrenFragment(R.id.containerFrame, new SearchFragmentPresenter().getFragment(), null, false, SearchFragment.class.getName());
  }

  @OnClick(R.id.btnGetAnswer)
  void getAnswer() {
    addOrShowChildrenFragment(R.id.containerFrame, new AnswerFragmentPresenter().getFragment(), null, false, AnswerFragment.class.getName());
  }

  private void addControls() {

  }

  @Override
  public HomeActivityContract.Presenter createPresenter() {
    return new HomeActivityPresenter();
  }


}
