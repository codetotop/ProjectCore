package com.dungnb.gem.projectcore.pojo.business_model;

import com.google.gson.annotations.SerializedName;

public class AnswerDTO {
  @SerializedName("answer_id")
  private String mAnswerId;
  @SerializedName("question_id")
  private String mQuestionId;

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
}
