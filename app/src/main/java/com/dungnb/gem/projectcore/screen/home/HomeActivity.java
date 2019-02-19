package com.dungnb.gem.projectcore.screen.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.dungnb.gem.projectcore.R;
import com.dungnb.gem.projectcore.base.pattern_viper.activity.BaseActivity;
import com.dungnb.gem.projectcore.pojo.model.Question;
import com.dungnb.gem.projectcore.screen.adapter.QuestionAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

@SuppressLint("CheckResult")

public class HomeActivity extends BaseActivity<HomeActivityContract.Presenter> implements HomeActivityContract.View {
  @BindView(R.id.rcvQuestion)
  SuperRecyclerView mRcvQuestion;
  QuestionAdapter mQuestionAdapter;
  ArrayList<Question> mQuestions;

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
  void getQuestion(){
    getPresenter().getQuestion();
  }


  private void addControls() {
    mQuestions = new ArrayList<>();
    mQuestionAdapter = new QuestionAdapter(this, mQuestions);
    mRcvQuestion.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    mRcvQuestion.setAdapter(mQuestionAdapter);
  }
  @Override
  public HomeActivityContract.Presenter createPresenter() {
    return new HomeActivityPresenter();
  }

  @Override
  public void updateUI(List<Question> questions) {
    mQuestionAdapter.refreshList((ArrayList<Question>) questions);
  }

  @Override
  public void showError() {
    Toast.makeText(HomeActivity.this, "Have error !", Toast.LENGTH_SHORT).show();
  }
}
