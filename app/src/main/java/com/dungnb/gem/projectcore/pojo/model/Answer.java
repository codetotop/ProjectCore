package com.dungnb.gem.projectcore.pojo.model;

import com.dungnb.gem.projectcore.pojo.business_model.AnswerDTO;

public class Answer {
  private String mAnswerId;
  private String mQuestionId;

  public Answer() {
  }

  public Answer(String answerId, String questionId) {
    mAnswerId = answerId;
    mQuestionId = questionId;
  }

  public String getAnswerId() {
    return mAnswerId;
  }

  public void setAnswerId(String answerId) {
    mAnswerId = answerId;
  }

  public String getQuestionId() {
    return mQuestionId;
  }

  public void setQuestionId(String questionId) {
    mQuestionId = questionId;
  }

  public void convert(AnswerDTO answerDTO) {
    mAnswerId = answerDTO.getAnswerId();
    mQuestionId = answerDTO.getQuestionId();
  }
}
