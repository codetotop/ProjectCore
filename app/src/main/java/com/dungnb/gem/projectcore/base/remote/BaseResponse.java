package com.dungnb.gem.projectcore.base.remote;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {
  @SerializedName("data")
  private T mData;
  @SerializedName("response_code")
  private int mResponseCode;
  @SerializedName("message")
  private String mMessage;

  public T getData() {
    return mData;
  }

  public void setData(T data) {
    mData = data;
  }

  public int getResponseCode() {
    return mResponseCode;
  }

  public void setResponseCode(int responseCode) {
    mResponseCode = responseCode;
  }

  public String getMessage() {
    return mMessage;
  }

  public void setMessage(String message) {
    mMessage = message;
  }
}
