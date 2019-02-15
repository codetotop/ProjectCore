package com.dungnb.gem.projectcore.pojo.response;

import com.dungnb.gem.projectcore.pojo.business_model.SourceChildrenDTO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SourceChildrenResponse {
  @SerializedName("total_records")
  private String mTotalRecords;
  @SerializedName("assets")
  private List<SourceChildrenDTO> mSourceChildrenDTOS;

  public SourceChildrenResponse() {
  }

  public SourceChildrenResponse(String totalRecords, List<SourceChildrenDTO> sourceChildrenDTOS) {
    mTotalRecords = totalRecords;
    mSourceChildrenDTOS = sourceChildrenDTOS;
  }

  public String getTotalRecords() {
    return mTotalRecords;
  }

  public void setTotalRecords(String totalRecords) {
    mTotalRecords = totalRecords;
  }

  public List<SourceChildrenDTO> getSourceChildrenDTOS() {
    return mSourceChildrenDTOS;
  }

  public void setSourceChildrenDTOS(List<SourceChildrenDTO> sourceChildrenDTOS) {
    mSourceChildrenDTOS = sourceChildrenDTOS;
  }
}
