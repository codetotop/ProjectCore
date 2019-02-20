package com.dungnb.gem.projectcore.screen.questions_history;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.dungnb.gem.projectcore.R;
import com.dungnb.gem.projectcore.base.pattern_viper.fragment.BaseFragment;
import com.dungnb.gem.projectcore.common.Constants;
import com.dungnb.gem.projectcore.pojo.model.Question;
import com.dungnb.gem.projectcore.screen.adapter.QuestionAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

public class QuestionFragment extends BaseFragment<QuestionFragmentContract.Presenter>
        implements QuestionFragmentContract.View {
  private static QuestionFragment mInstance;

  @BindView(R.id.rcvQuestion)
  SuperRecyclerView mRcvQuestion;
  private QuestionAdapter mQuestionAdapter;
  private ArrayList<Question> mQuestions;

  public static QuestionFragment getInstance() {
    if (mInstance == null)
      mInstance = new QuestionFragment();
    return mInstance;
  }

  @Override
  protected int getLayoutResourceID() {
    return R.layout.fragment_question;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    setUpView();
  }

  @Override
  public void onResume() {
    super.onResume();
    getData();
  }

  private void setUpView() {
    mRcvQuestion.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    mQuestions = new ArrayList<>();
    mQuestionAdapter = new QuestionAdapter(getContext(), mQuestions);
    mRcvQuestion.setAdapter(mQuestionAdapter);
  }

  private void getData() {
    getPresenter().fetchQuestion();
  }

  @Override
  public void updateUI(ArrayList<Question> questions) {
    mQuestionAdapter.refreshList(questions);
  }

  @Override
  public void showError() {
    Toast.makeText(getContext(), "Have error !", Toast.LENGTH_SHORT).show();
  }

}
