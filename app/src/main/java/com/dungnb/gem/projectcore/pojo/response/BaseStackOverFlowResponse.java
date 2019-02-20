package com.dungnb.gem.projectcore.pojo.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseStackOverFlowResponse<T> {
  @SerializedName("items")
  List<T> mItems;

  public List<T> getItems() {
    return mItems;
  }

  public void setItems(List<T> items) {
    mItems = items;
  }
}
