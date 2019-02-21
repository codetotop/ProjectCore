package com.dungnb.gem.projectcore.utils;

/**
 * Created by Ha Anh on 3/23/2018.
 */

public class Logger {

  public static void logException(Exception e) {
    e.printStackTrace();
  }

  public static void logException(Throwable throwable) {
    throwable.printStackTrace();
  }
}
