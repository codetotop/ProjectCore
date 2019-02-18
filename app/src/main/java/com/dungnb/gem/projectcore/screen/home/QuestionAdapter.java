package com.dungnb.gem.projectcore.screen.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dungnb.gem.projectcore.R;
import com.dungnb.gem.projectcore.pojo.model.Question;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionHolder> {
  ArrayList<Question> mQuestions;
  Context mContext;

  public QuestionAdapter(Context context, ArrayList<Question> questions) {
    mQuestions = questions;
    mContext = context;
  }

  @NonNull
  @Override
  public QuestionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.item_question, viewGroup, false);
    return new QuestionHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull QuestionHolder questionHolder, int i) {
    Question question = mQuestions.get(i);
    questionHolder.mTvQuestionId.setText(question.getQuestionId());
    questionHolder.mTvQuestion.setText(question.getTitle());
    questionHolder.mTvQuestionViewCount.setText(question.getViewCount());
  }

  @Override
  public int getItemCount() {
    return mQuestions.size();
  }

  public void refreshList(ArrayList<Question> questions) {
    mQuestions.clear();
    mQuestions.addAll(questions);
    notifyDataSetChanged();
  }

  class QuestionHolder extends RecyclerView.ViewHolder {
    TextView mTvQuestion;
    TextView mTvQuestionId;
    TextView mTvQuestionViewCount;

    public QuestionHolder(@NonNull View itemView) {
      super(itemView);
      mTvQuestion = itemView.findViewById(R.id.tvQuestion);
      mTvQuestionId = itemView.findViewById(R.id.tvQuestionId);
      mTvQuestionViewCount = itemView.findViewById(R.id.tvQuestionViewCount);
    }
  }
}
