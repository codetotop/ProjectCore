package com.dungnb.gem.projectcore.screen.answer_history;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.dungnb.gem.projectcore.R;
import com.dungnb.gem.projectcore.base.pattern_mvp.fragment.BaseFragment;
import com.dungnb.gem.projectcore.pojo.model.Answer;
import com.dungnb.gem.projectcore.screen.adapter.AnswerAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

public class AnswerFragment
        extends BaseFragment<AnswerFragmentContract.Presenter> implements AnswerFragmentContract.View {

  private static AnswerFragment mInstance;
  @BindView(R.id.rcvAnswer)
  SuperRecyclerView mRcvAnswer;
  private AnswerAdapter mAnswerAdapter;
  private ArrayList<Answer> mAnswers;

  public static AnswerFragment getInstance() {
    if (mInstance == null)
      mInstance = new AnswerFragment();
    return mInstance;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    setUpView();
  }

  private void setUpView() {
    mRcvAnswer.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    mAnswers = new ArrayList<>();
    mAnswerAdapter = new AnswerAdapter(getContext(), mAnswers);
    mRcvAnswer.setAdapter(mAnswerAdapter);
  }

  private void getData() {
    getPresenter().fetchAnswers();
  }

  @Override
  public void onResume() {
    super.onResume();
    getData();
  }

  @Override
  public void onPause() {
    super.onPause();
  }

  @Override
  protected int getLayoutResourceID() {
    return R.layout.fragment_answer;
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
  }

  @Override
  public void fetchAnswersSuccess(ArrayList<Answer> answers) {
    mAnswerAdapter.refreshList(answers);
  }

  @Override
  public void fetchError(String message_error) {
    Toast.makeText(getContext(), message_error, Toast.LENGTH_SHORT).show();
  }
}
