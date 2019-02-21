package com.dungnb.gem.projectcore.pojo.response;

import com.dungnb.gem.projectcore.pojo.business_model.QuestionDTO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionResponse {
  @SerializedName("items")
  private List<QuestionDTO> mQuestionDTOS;

  public List<QuestionDTO> getQuestionDTOS() {
    return mQuestionDTOS;
  }

  public void setQuestionDTOS(List<QuestionDTO> questionDTOS) {
    mQuestionDTOS = questionDTOS;
  }
}
