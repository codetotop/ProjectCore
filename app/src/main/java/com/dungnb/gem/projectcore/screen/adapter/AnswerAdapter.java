package com.dungnb.gem.projectcore.screen.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dungnb.gem.projectcore.R;
import com.dungnb.gem.projectcore.pojo.model.Answer;
import com.dungnb.gem.projectcore.pojo.model.Question;

import java.util.ArrayList;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.QuestionHolder> {
  ArrayList<Answer> mAnswers;
  Context mContext;

  public AnswerAdapter(Context context, ArrayList<Answer> answers) {
    mAnswers = answers;
    mContext = context;
  }

  @NonNull
  @Override
  public QuestionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.item_answer, viewGroup, false);
    return new QuestionHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull QuestionHolder questionHolder, int i) {
    Answer answer = mAnswers.get(i);
    questionHolder.mTvAnswerId.setText(mContext.getString(R.string.answer_id) + " " + answer.getAnswerId());
    questionHolder.mTvQuestionId.setText(mContext.getString(R.string.question_id) + " " + answer.getQuestionId());
  }

  @Override
  public int getItemCount() {
    return mAnswers.size();
  }

  public void refreshList(ArrayList<Answer> answers) {
    mAnswers.clear();
    mAnswers.addAll(answers);
    notifyDataSetChanged();
  }

  class QuestionHolder extends RecyclerView.ViewHolder {
    TextView mTvAnswerId;
    TextView mTvQuestionId;

    public QuestionHolder(@NonNull View itemView) {
      super(itemView);
      mTvAnswerId = itemView.findViewById(R.id.tvAnswerId);
      mTvQuestionId = itemView.findViewById(R.id.tvQuestionId);
    }
  }
}
