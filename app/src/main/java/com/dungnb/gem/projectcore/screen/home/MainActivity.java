package com.dungnb.gem.projectcore.screen.home;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.dungnb.gem.projectcore.R;
import com.dungnb.gem.projectcore.pojo.business_model.QuestionDTO;
import com.dungnb.gem.projectcore.pojo.model.Question;
import com.dungnb.gem.projectcore.webservice.WebServiceBuilder;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Single;

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
    WebServiceBuilder.getInstance().getProjectService().fetchQuestionList("desc", "activity", "Android", "stackoverflow")
            .flatMap(questionResponse -> {
              ArrayList<QuestionDTO> questionDTOS = (ArrayList<QuestionDTO>) questionResponse.getQuestionDTOS();
              ArrayList<Question> questions = new ArrayList<>();
              for (int i = 0; i < questionDTOS.size(); i++) {
                Question question = new Question();
                question.convert(questionDTOS.get(i));
                questions.add(question);
              }
              mQuestionAdapter.refreshList(questions);
              return Single.just(questions);
            });
  }

  private void addEvents() {

  }

}
