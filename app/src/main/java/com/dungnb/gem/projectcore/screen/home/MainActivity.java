package com.dungnb.gem.projectcore.screen.home;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.dungnb.gem.projectcore.R;
import com.dungnb.gem.projectcore.pojo.business_model.QuestionDTO;
import com.dungnb.gem.projectcore.pojo.model.Question;
import com.dungnb.gem.projectcore.webservice.WebServiceBuilder;
import com.dungnb.gem.projectcore.webservice.content.ProjectRespository;
import com.dungnb.gem.projectcore.webservice.content.ProjectService;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@SuppressLint("CheckResult")

public class MainActivity extends AppCompatActivity {
  @BindView(R.id.rcvQuestion)
  SuperRecyclerView mRcvQuestion;
  QuestionAdapter mQuestionAdapter;
  ArrayList<Question> mQuestions;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    addControls();
    getQuestions();
    addEvents();
  }


  private void addControls() {
    mQuestions = new ArrayList<>();
    mQuestionAdapter = new QuestionAdapter(this, mQuestions);
    mRcvQuestion.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    mRcvQuestion.setAdapter(mQuestionAdapter);
  }

  private void getQuestions() {
    ProjectRespository.fetchQuestions("desc", "activity", "Android", "stackoverflow")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(questions -> {
              updateUI(questions);
            }, throwable -> {
              showError();
            });
  }

  private void showError() {
  }

  private void updateUI(List<Question> questions) {
    mQuestionAdapter.refreshList((ArrayList<Question>) questions);
  }

  private void addEvents() {

  }

}
