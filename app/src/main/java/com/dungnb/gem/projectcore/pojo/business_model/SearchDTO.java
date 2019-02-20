package com.dungnb.gem.projectcore.pojo.business_model;

import com.google.gson.annotations.SerializedName;

public class SearchDTO {
  @SerializedName("title")
  String mTitle;
  @SerializedName("question_id")
  String mQuestionId;
  @SerializedName("view_count")
  String mViewCount;

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
