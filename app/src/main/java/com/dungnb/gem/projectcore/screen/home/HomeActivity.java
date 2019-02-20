package com.dungnb.gem.projectcore.screen.home;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.dungnb.gem.projectcore.base.pattern_viper.activity.BaseActivity;
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
    replaceChildrenFragment(new QuestionFragmentPresenter().getFragment(), R.id.containerFrame, true, QuestionFragment.class.getName());
  }

  @OnClick(R.id.btnGetSearch)
  void getSearch() {
    replaceChildrenFragment(new SearchFragmentPresenter().getFragment(), R.id.containerFrame, true, SearchFragment.class.getName());
  }

  private void addControls() {

  }

  @Override
  public HomeActivityContract.Presenter createPresenter() {
    return new HomeActivityPresenter();
  }


}
