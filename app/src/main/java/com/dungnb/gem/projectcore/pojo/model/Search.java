package com.dungnb.gem.projectcore.pojo.model;

import com.dungnb.gem.projectcore.pojo.business_model.QuestionDTO;
import com.dungnb.gem.projectcore.pojo.business_model.SearchDTO;

public class Search {
  private String mTitle;
  private String mQuestionId;
  private String mViewCount;

  public void convert(SearchDTO searchDTO) {
    mTitle = searchDTO.getTitle();
    mQuestionId = searchDTO.getQuestionId();
    mViewCount = searchDTO.getViewCount();
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
