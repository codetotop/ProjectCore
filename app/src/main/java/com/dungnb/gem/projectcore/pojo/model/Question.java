package com.dungnb.gem.projectcore.pojo.model;

import com.dungnb.gem.projectcore.pojo.business_model.QuestionDTO;
import com.google.gson.annotations.SerializedName;

public class Question {
  private String mTitle;
  private String mQuestionId;
  private String mViewCount;

  public void convert(QuestionDTO questionDTO) {
    mTitle = questionDTO.getTitle();
    mQuestionId = questionDTO.getQuestionId();
    mViewCount = questionDTO.getViewCount();
  }

  public String getTitle() {
    return mTitle;
  }

  public void setTitle(String title) {
    mTitle = title;
  }

  public String getQuestionId() {
    return mQuestionId;
  }

  public void setQuestionId(String questionId) {
    mQuestionId = questionId;
  }

  public String getViewCount() {
    return mViewCount;
  }

  public void setViewCount(String viewCount) {
    mViewCount = viewCount;
  }

}
