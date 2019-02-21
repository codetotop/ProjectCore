package com.dungnb.gem.projectcore.base.remote;

import android.content.Context;
import android.os.Build;
import android.system.ErrnoException;

import com.dungnb.gem.projectcore.R;
import com.dungnb.gem.projectcore.utils.JsonHelper;
import com.dungnb.gem.projectcore.utils.NetworkUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.HttpException;

/**
 * Created by GEM on 12/30/2017.
 */

public class ErrorHandler {
  private static final int DEFAULT_CODE = -1;
  private static String DEFAULT_MESSAGE = "";
  private static final String ERROR_TAG = "error";
  public static String OFFLINE_MSG = "offline";

  private Context context;

  private static ErrorHandler sInstance;

  private int mCode;
  private String mMessage;

  public ErrorHandler(){

  }

  public static ErrorHandler getInstance() {
    if (sInstance == null) {
      synchronized (ErrorHandler.class) {
        if (sInstance == null)
          sInstance = new ErrorHandler();
      }
    }
    return sInstance;
  }

  public void init(Context context) {
    this.context = context;
    DEFAULT_MESSAGE = context.getString(R.string.general_error_message);
    OFFLINE_MSG = context.getString(R.string.offline_message);
  }

  public int getCode() {
    return mCode;
  }

  public String getMessage() {
    return mMessage;
  }

  public void handleError(Throwable throwable) {
    mCode = -1;
    if (NetworkUtil.checkNetwork(context) == NetworkUtil.NetworkType.DISCONNECT) {
      mMessage = context.getString(R.string.offline_message);
    } else {
      if (throwable instanceof HttpException) {
        HttpException httpException = (HttpException) throwable;
        try {
          String errorResponse = httpException.response().errorBody().string();
          if (!JsonHelper.isJson(errorResponse)) {
            mCode = DEFAULT_CODE;
            mMessage = DEFAULT_MESSAGE;
          } else {
            JsonObject errorObject = new JsonParser().parse(errorResponse).getAsJsonObject();
            if (errorObject.has(ERROR_TAG)) {
              BaseResponse result = JsonHelper.getGson()
                      .fromJson(errorObject.get(ERROR_TAG), BaseResponse.class);
              mCode = result.getResponseCode();
              mMessage = result.getMessage();
            } else {
              mCode = DEFAULT_CODE;
              mMessage = DEFAULT_MESSAGE;
            }
          }
        } catch (IOException e) {
          mCode = DEFAULT_CODE;
          mMessage = DEFAULT_MESSAGE;
        }
      }else if(throwable instanceof SocketTimeoutException ||
              throwable instanceof ConnectException || (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP &&
              throwable instanceof ErrnoException)){
        mCode = DEFAULT_CODE;
        mMessage = OFFLINE_MSG;
      }
      else {
        mCode = DEFAULT_CODE;
        mMessage = DEFAULT_MESSAGE;
      }
    }
  }
}
